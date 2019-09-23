package tacocloud.demo.data;

import tacocloud.demo.domain.Order;

public interface OrderRepo {
    Order save(Order order);
}
