package test.springdataredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by joshua on 17/3/20.
 */
public class OrderDao {

    @Autowired
    private RedisTemplate<String, Order> redisTemplate;

    public void save(Order order) {
        ValueOperations<String, Order> valueOper = redisTemplate.opsForValue();
        valueOper.set(order.getId(), order);
    }

    public Order read(String id) {
        ValueOperations<String, Order> valueOper = redisTemplate.opsForValue();
        return valueOper.get(id);
    }

    public void delete(String id) {
        ValueOperations<String, Order> valueOper = redisTemplate.opsForValue();
        RedisOperations<String, Order> RedisOperations = valueOper.getOperations();
        RedisOperations.delete(id);
    }
}
