package wrk.esb.data.hr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import wrk.esb.api.hr.Employee;

/**
 * @author Dirk
 *
 */
@Entity
@Table(name = "T_EMPLYEE")
public class EmployeeEntity implements Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String account;
	private String email;

	public EmployeeEntity() {
	}

	public EmployeeEntity(String account) {
		this.account = account;
		this.email = account + "@wrk.be";
	}

	@Override
	public String getAccount() {
		return account;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return String.format("Employee [account=%s, email=%s]", account, email);
	}

}
