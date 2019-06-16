package wrk.esb.api;

import java.util.Set;

import wrk.esb.api.hr.Person;

public interface HrService {
  
  @Api("/hr/persons")
  Set<Person> getAllPeople();
  
  @Api(value= "/hr/persons/example", method = "POST")
  Set<Person> getAllPeopleLikeExample(Person person);
  
  @Api("/hr/persons/email/{email}")
  Person getByEmail(String email);

}
