package wrk.esb.data.repo.hr;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import wrk.esb.api.hr.Employee;
import wrk.esb.data.hr.EmployeeEntity;

public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Long>{
  
  <T> Set<T> findBy(Class<T> type);
  
  Set<Employee> findByEmail(String email);
  
  Set<Employee> findByAccount(String account);
}
