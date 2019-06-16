package wrk.esb.data.repo.mr;

import org.springframework.data.repository.PagingAndSortingRepository;

import wrk.esb.api.mr.Account;
import wrk.esb.data.mr.AccountEntity;

public interface AccountRepository extends PagingAndSortingRepository<AccountEntity, Long> {
  
  Account findOneByAccount(String account);
}
