package wrk.esb.core.service;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wrk.esb.api.HrService;
import wrk.esb.api.hr.Employee;
import wrk.esb.api.hr.Person;
import wrk.esb.data.repo.hr.HrRepositories;

@RestController
@RequestMapping("/hr/")
public class HrController implements HrService {
    
  private final HrRepositories hrRepositories;

	public HrController(HrRepositories hrRepositories) {
		this.hrRepositories = hrRepositories;
	}

	@Override @GetMapping("persons")
	public Set<Person> getAllPeople() {
		return hrRepositories.getPeopleRepository().findBy(Person.class);
	}

	@Override @PostMapping("persons/example")
	public Set<Person> getAllPeopleLikeExample(Person person) {
		return null;
	}

	@Override  @GetMapping("persons/email/{email}")
	public Person getByEmail(@PathVariable String email) {
		return hrRepositories.getPeopleRepository().findByEmail(email);
	}
	
	@GetMapping("employees")
	public Set<Employee> findAllEmployees(){
	  return hrRepositories.getEmployeeRepository().findBy(Employee.class);
	}
  
	
}
