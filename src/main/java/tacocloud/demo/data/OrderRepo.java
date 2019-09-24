package tacocloud.demo.data;

import org.springframework.data.repository.CrudRepository;
import tacocloud.demo.domain.Order;

public interface OrderRepo extends CrudRepository<Order, Long> {

}
