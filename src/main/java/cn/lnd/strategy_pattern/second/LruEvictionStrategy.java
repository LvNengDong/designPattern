package cn.lnd.strategy_pattern.second;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/27 19:13
 */
public class LruEvictionStrategy implements EvictionStrategy{
    @Override
    public void eviction() {
        System.out.println("使用LRU算法驱逐");
    }
}
