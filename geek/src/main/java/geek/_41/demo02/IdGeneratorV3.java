package geek._41.demo02;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author lnd
 * @Description 双重检查锁单例
 * @Date 2024/4/3 20:48
 */
public class IdGeneratorV3 {

    private IdGeneratorV3 (){}
    private static IdGeneratorV3 instance;
    public static IdGeneratorV3 getInstance() {
        // 相比于懒汉式单例，这种单例锁的范围更小，只在第一次创建对象实例时加锁
        if (instance == null) { //一重检查
            synchronized (IdGeneratorV3.class) {
                if (instance == null) { //双重检查
                    instance = new IdGeneratorV3();
                }
            }
        }
        return instance;
    }

    private AtomicLong id = new AtomicLong(0);
    public long getId() {
        return id.incrementAndGet();
    }
}
