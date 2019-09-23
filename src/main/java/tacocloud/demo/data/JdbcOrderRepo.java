package tacocloud.demo.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import tacocloud.demo.domain.Ingredient;
import tacocloud.demo.domain.Order;
import tacocloud.demo.domain.Taco;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

@Repository
public class JdbcOrderRepo implements OrderRepo {


    @Override
    public Order save(Order order) {
        return null;
    }
}
