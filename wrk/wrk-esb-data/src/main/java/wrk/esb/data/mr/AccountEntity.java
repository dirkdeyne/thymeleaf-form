package wrk.esb.data.mr;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import wrk.esb.api.mr.Account;
import wrk.esb.api.mr.Computer;

@Entity
@Table(name = "T_ACCOUNT")
public class AccountEntity implements Account {

	@Id
	@GeneratedValue
	private Long id;

	private String account;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_computer_account")
	private Set<ComputerEntity> computers;

	public AccountEntity() {
	}

	public AccountEntity(String account, Set<ComputerEntity> computers) {
		this.account = account;
		this.computers = computers;
	}

	public String getAccount() {
		return account;
	}

	@Override
	public Set<Computer> getComputers() {
		return computers.stream().map(c -> (Computer) c).collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return String.format("Account [account=%s, computers=%s]", account, computers);
	}

}
