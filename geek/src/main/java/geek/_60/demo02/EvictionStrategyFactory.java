package geek._60.demo02;

import geek._60.demo01.ConcreteStrategyA;
import geek._60.demo01.ConcreteStrategyB;
import geek._60.demo01.Strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/27 21:34
 */
public class EvictionStrategyFactory {
    /**
     * key 策略代号
     * val 策略实现类
     */
    private static final Map<String, EvictionStrategy> strategies = new HashMap<>();

    static {
        strategies.put("LruEvictionStrategy", new LruEvictionStrategy());
        strategies.put("LfuEvictionStrategy", new LfuEvictionStrategy());
        strategies.put("FifoEvictionStrategy", new FifoEvictionStrategy());
    }

    public static EvictionStrategy getEvictionStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }
}
