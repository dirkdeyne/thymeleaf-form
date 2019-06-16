package wrk.esb.data.repo.mr;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import wrk.esb.api.mr.Computer;
import wrk.esb.api.mr.Type;
import wrk.esb.data.mr.ComputerEntity;

public interface ComputerRepository extends PagingAndSortingRepository<ComputerEntity, Long>  {
  
  Set<Computer> findByType(Type type);
  
}
