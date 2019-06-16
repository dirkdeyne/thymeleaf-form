package wrk.esb.config;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import wrk.esb.api.mr.Os;
import wrk.esb.api.mr.Type;
import wrk.esb.data.hr.EmployeeEntity;
import wrk.esb.data.hr.PersonEntity;
import wrk.esb.data.mr.AccountEntity;
import wrk.esb.data.mr.ComputerEntity;
import wrk.esb.data.repo.hr.HrRepositories;
import wrk.esb.data.repo.mr.MrRepositories;

@Component
public class DataInitializer {

	private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

	private final HrRepositories hrRepositories;

	private final MrRepositories mrRepositories;
	
	boolean init;
	
	public DataInitializer(HrRepositories hrRepositories, MrRepositories mrRepositories, Environment environment) {
		this.hrRepositories = hrRepositories;
		this.mrRepositories = mrRepositories;
		boolean update = environment.getProperty("spring.jpa.hibernate.ddl-auto").equalsIgnoreCase("update");
		boolean empty = 0 == hrRepositories.getEmployeeRepository().count();
		init = !update && empty;
		log.debug("init = !"+update + " && " + empty + " = " + init);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
	  if(init) {
		setupPeople();
		setupComputers();
		setupEmployees();
		setupAccounts();
	  } else {
	    
	    log.debug("found people   : " + hrRepositories.getPeopleRepository().findAll());
	    log.debug("found computers: " + mrRepositories.getComputerRepository().findAll());
	    log.debug("found accounts : " + mrRepositories.getAccountRepository().findAll());
	    log.debug("found employees: " + hrRepositories.getEmployeeRepository().findAll());
	  }
	}

	private void setupPeople() {
		Stream.of("Deyne,Dirk;deyne.d@wrk.be", "Groosman,Nicole;groosman.n@wrk.be", "Deyne,Kevin;deyne.k@wrk.be", "Deyne,Ceci;deyne.c@wrk.be")
		        .map(strg -> strg.split(";"))
		        .map(fullnameAndEmail -> new PersonEntity(fullnameAndEmail[0],fullnameAndEmail[1]))
				.forEach(person -> hrRepositories.getPeopleRepository().save(person));

		log.debug("setup people: " + hrRepositories.getPeopleRepository().findAll());
	}

	private void setupComputers() {
		Stream.of(
		    new ComputerEntity(Type.PC, Os.WINDOWS), new ComputerEntity(Type.PC, Os.WINDOWS),new ComputerEntity(Type.PC, Os.WINDOWS), 
		    new ComputerEntity(Type.LAPTOP, Os.WINDOWS),new ComputerEntity(Type.LAPTOP, Os.WINDOWS),
		    new ComputerEntity(Type.LAPTOP, Os.MACOS),new ComputerEntity(Type.LAPTOP, Os.MACOS),
		    new ComputerEntity(Type.SERVER, Os.LINUX),new ComputerEntity(Type.SERVER, Os.LINUX))
				.forEach(comp -> mrRepositories.getComputerRepository().save(comp));

		log.debug("setup computers: " + mrRepositories.getComputerRepository().findAll());
	}

	private void setupAccounts() {
	  List<ComputerEntity> computers = StreamSupport.stream(mrRepositories.getComputerRepository().findAll().spliterator(),false).collect(Collectors.toList());
	  Stream.of("deyne.d;1,5","deyne.k;2,6","deyne.c;3,7","groosman.n;4","cel.linux;8,9")
	        .map(s -> s.split(";"))
	        .map(sar -> new AccountEntity(sar[0], computers(computers,sar[1].split(","))))
	        .forEach(entity -> mrRepositories.getAccountRepository().save(entity));;
	   
	  log.debug("setup accounts: " + mrRepositories.getAccountRepository().findAll());      
	}

	private Set<ComputerEntity> computers(List<ComputerEntity> computers, String[] nrs) {
	  return Stream.of(nrs).map(nr -> Integer.valueOf(nr)).map(nr -> computers.get(nr-1)).collect(Collectors.toSet());
	}

	private void setupEmployees() {
	  Stream.of("deyne.d","deyne.k","deyne.c","groosman.n","cel.linux")
	        .map(name-> new EmployeeEntity(name))
	        .forEach(emp -> hrRepositories.getEmployeeRepository().save(emp));
	  
	 log.debug("setup employees: " + hrRepositories.getEmployeeRepository().findAll());
	}

}