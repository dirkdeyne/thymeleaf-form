package wrk.esb.data.repo.mr;

import org.springframework.stereotype.Component;

@Component
public class MrRepositories {

	private final ComputerRepository computerRepository;

	private final AccountRepository accountRepository;

	public MrRepositories(ComputerRepository computerRepository, AccountRepository accountRepository) {
		this.computerRepository = computerRepository;
		this.accountRepository = accountRepository;
	}

	public ComputerRepository getComputerRepository() {
		return computerRepository;
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

}
