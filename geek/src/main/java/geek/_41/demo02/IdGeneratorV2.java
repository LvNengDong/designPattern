package geek._41.demo02;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author lnd
 * @Description 懒汉式单例
 * @Date 2024/4/3 20:41
 */
public class IdGeneratorV2 {
    // 私有化构造方法
    private IdGeneratorV2() {}

    private static IdGeneratorV2 instance;

    // 提供公有的获取实例方法
    public static synchronized IdGeneratorV2 getInstance() {
        if (instance == null) {
            instance = new IdGeneratorV2();
        }
        return instance;
    }

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
