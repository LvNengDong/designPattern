package geek._41.demo02;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author lnd
 * @Description 饿汉式单例
 * @Date 2024/4/3 20:38
 */
public class IdGenerator {
    // 私有化构造方法
    private IdGenerator() {}

    // 在类加载时创建单例对象
    private static final IdGenerator instance = new IdGenerator();

    // 提供公有的获取实例方法
    public IdGenerator getInstance() {
        return instance;
    }

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
