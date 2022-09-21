package cn.lnd.observer.demo04;

import java.util.concurrent.Executor;

/**
 * @Author lnd
 * @Description
 * @Date 2022/9/20 20:32
 */
public class AsyncEventBus extends EventBus{

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
