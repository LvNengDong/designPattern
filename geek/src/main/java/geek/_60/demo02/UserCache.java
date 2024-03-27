package geek._60.demo02;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/27 21:30
 */
public class UserCache {

    private EvictionStrategy eviction;

    public UserCache(EvictionStrategy eviction) {
        this.eviction = eviction;
    }
}
