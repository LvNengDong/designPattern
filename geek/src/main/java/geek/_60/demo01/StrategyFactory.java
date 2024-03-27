package geek._60.demo01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/27 21:13
 */
public class StrategyFactory {
    /**
     * key 策略代号
     * val 策略实现类
     */
    private static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }
}
