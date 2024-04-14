package geek._29.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/3 15:19
 */
public class RedisDistributedLock {

    private static RedisDistributedLock instance = new RedisDistributedLock();

    public static RedisDistributedLock getSingletonInstance() {
        return instance;
    }

    public boolean lockTransction(String id) {
        return true;
    }
    public boolean unlockTransction(String id) {
        return true;
    }
}
