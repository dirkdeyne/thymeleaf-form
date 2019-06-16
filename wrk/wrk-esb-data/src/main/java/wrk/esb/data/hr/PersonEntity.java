package wrk.esb.data.hr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

import wrk.esb.api.hr.Person;

@Entity
@Table(name = "T_PERSON")
public class PersonEntity implements Person {

  @Id
  @GeneratedValue
  private Long id;

  private String lastname, firstname, email;

  public PersonEntity() {
  }

  public PersonEntity(String fullname, String email) {
      Assert.isTrue(fullname.contains(","), "Not a full name");
      String[] split = fullname.split(",");
      lastname = split[0];
      firstname = split[1];
      this.email = email;
  }

  public String getLastname() {
      return lastname;
  }

  public void setLastname(String lastname) {
      this.lastname = lastname;
  }

  public String getFirstname() {
      return firstname;
  }

  public void setFirstname(String firstname) {
      this.firstname = firstname;
  }
  
  @Override
  public String getEmail() {
		return email;
  }

  public Long getId() {
      return id;
  }

  @Override
  public String toString() {
      return "Person [lastname=" + lastname + ", firstname=" + firstname + "]";
  }
}
