package geek._60.demo02;

/**
 * @Author lnd
 * @Description 非运行时动态确定，在代码中指定使用哪种策略
 * @Date 2024/3/27 21:30
 */
public class Application {
    public static void main(String[] args) {
        // ...
        EvictionStrategy evictionStrategy = new LruEvictionStrategy();
        UserCache userCache = new UserCache(evictionStrategy);
        // ...
    }
}
