package cn.lnd.strategy_pattern.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/27 19:15
 */
public class UserCache {
    private Map<String, User> cacheData = new HashMap();

    private EvictionStrategy eviction;

    public UserCache(EvictionStrategy eviction) {
        this.eviction = eviction;
    }
}
