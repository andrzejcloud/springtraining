package tacocloud.demo.data;

import org.springframework.data.repository.CrudRepository;
import tacocloud.demo.domain.Taco;

public interface TacoRepo extends CrudRepository<Taco, Long> {

}
