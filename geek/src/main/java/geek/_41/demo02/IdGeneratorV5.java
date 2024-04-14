package geek._41.demo02;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author lnd
 * @Description 枚举实现单例
 * @Date 2024/4/3 21:04
 */
public enum IdGeneratorV5 {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
