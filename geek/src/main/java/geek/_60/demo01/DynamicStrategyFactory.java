package geek._60.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/27 21:23
 */
public class DynamicStrategyFactory {

    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        if (type.equals("A")) {
            return new ConcreteStrategyA();
        } else if (type.equals("B")) {
            return new ConcreteStrategyB();
        }
        return null;
    }
}
