package wrk.esb.core.service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wrk.esb.api.MrService;
import wrk.esb.api.mr.Account;
import wrk.esb.api.mr.Computer;
import wrk.esb.api.mr.Type;
import wrk.esb.data.repo.mr.MrRepositories;

@RestController
@RequestMapping(value = "/mr/")
public class MrController implements MrService {

	private final MrRepositories repositories;

	public MrController(MrRepositories repositories) {
		super();
		this.repositories = repositories;
	}

	@Override
	@GetMapping("computers")
	public Set<Computer> getAllComputers() {
		return StreamSupport.stream(repositories.getComputerRepository().findAll().spliterator(),false).collect(Collectors.toSet());
	}

	@Override
	@GetMapping("computers/type/{type}")
	public Set<Computer> getAllComputersByType(@PathVariable Type type) {
		return repositories.getComputerRepository().findByType(type);
	}
	
	@Override
    @GetMapping("accounts/account/{account}")
    public Account getAccount(@PathVariable String account) {
        return repositories.getAccountRepository().findOneByAccount(account);
    }
}
