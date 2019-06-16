package wrk.esb.api;

import java.util.Set;

import wrk.esb.api.mr.Account;
import wrk.esb.api.mr.Computer;
import wrk.esb.api.mr.Type;

public interface MrService {
  
  @Api("/mr/computers")
  Set<Computer> getAllComputers();
  
  @Api("/mr/computers/type/{type}")
  Set<Computer> getAllComputersByType(Type type);
  
  @Api("/mr/accounts/account/{account}")
  Account getAccount(String account);
  
}
