package cn.lnd.strategy_pattern.first;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/27 18:55
 */
public class StrategyFactoryStatus {

    public static Strategy getStrategy(String type){
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty");
        }
        if (type.equals("A")){
            return new ConcreteStrategyA();
        }else if (type.equals("B")){
            return new ConcreteStrategyB();
        }
        return null;
    }
}

