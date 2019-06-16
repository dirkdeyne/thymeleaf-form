package wrk.esb.data.repo.hr;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import wrk.esb.api.hr.Person;
import wrk.esb.data.hr.PersonEntity;

public interface PeopleRepository extends PagingAndSortingRepository<PersonEntity, Long> {
  
  <T> Set<T> findBy(Class<T> type);
  
  Person findByEmail(String email);
  
}