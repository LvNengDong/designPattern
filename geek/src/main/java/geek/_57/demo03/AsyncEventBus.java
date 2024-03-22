package geek._57.demo03;

import java.util.concurrent.Executor;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 17:38
 */
public class AsyncEventBus extends EventBus{

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
