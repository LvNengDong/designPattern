package cn.lnd.strategy_pattern.first;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/27 18:55
 */
public class StrategyFactory {

    private static final Map<String, Strategy> strategies = Maps.newHashMap();

    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type){
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty");
        }
        return strategies.get(type);
    }
}

