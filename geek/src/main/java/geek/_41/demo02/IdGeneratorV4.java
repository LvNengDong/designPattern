package geek._41.demo02;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author lnd
 * @Description 静态内部类实现单例
 * @Date 2024/4/3 20:59
 */
public class IdGeneratorV4 {


    private IdGeneratorV4() {}

    private static class SingletonHolder {
        private static final IdGeneratorV4 instance = new IdGeneratorV4();
    }

    public static IdGeneratorV4 getInstance() {
        return SingletonHolder.instance;
    }

    private AtomicLong id = new AtomicLong(0);
    public long getId() {
        return id.incrementAndGet();
    }
}
