package geek._60.demo03;

import geek._60.demo02.EvictionStrategy;
import geek._60.demo02.FifoEvictionStrategy;
import geek._60.demo02.LfuEvictionStrategy;
import geek._60.demo02.LruEvictionStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author lnd
 * @Description 策略工厂
 * @Date 2024/3/27 21:48
 */
public class DiscountStrategyFactory {
    /**
     * key 策略代号
     * val 策略实现类
     */
    private static final Map<String, DiscountStrategy> strategies = new HashMap<>();

    static {
        strategies.put("GrouponOrder", new GrouponDiscountStrategy());
        strategies.put("NormalOrder", new NormalDiscountStrategy());
        strategies.put("PromotionOrder", new PromotionDiscountStrategy());
    }

    public static DiscountStrategy getDiscountStrategy(Order order) {
        Set<String> orderTypes = strategies.keySet();
        if (orderTypes.contains(order.getType())) {
            return strategies.get(order.getType());
        }
        return null;
    }
}
