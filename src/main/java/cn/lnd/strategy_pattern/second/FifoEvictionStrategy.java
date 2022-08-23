package cn.lnd.strategy_pattern.second;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/27 19:14
 */
public class FifoEvictionStrategy implements EvictionStrategy{

    @Override
    public void eviction() {
        System.out.println("采用FIFO算法驱逐");
    }
}
