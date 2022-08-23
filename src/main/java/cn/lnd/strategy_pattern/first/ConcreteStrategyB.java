package cn.lnd.strategy_pattern.first;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/27 18:50
 */
public class ConcreteStrategyB implements Strategy{
    @Override
    public void algorithmInterface() {
        // 具体的算法
        System.out.println("算法B");
    }
}
