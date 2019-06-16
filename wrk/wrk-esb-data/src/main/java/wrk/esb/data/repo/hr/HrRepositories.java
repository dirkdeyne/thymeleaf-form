package wrk.esb.data.repo.hr;

import org.springframework.stereotype.Component;

@Component
public class HrRepositories {

	private final EmployeeRepository employeeRepository;

	private final PeopleRepository peopleRepository;

	public HrRepositories(EmployeeRepository employeeRepository, PeopleRepository peopleRepository) {
		this.employeeRepository = employeeRepository;
		this.peopleRepository = peopleRepository;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public PeopleRepository getPeopleRepository() {
		return peopleRepository;
	}

}
