package geek._57.demo03;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 17:38
 */
public class EventBus {

    // 注册中心
    private ObserverRegistry registry = new ObserverRegistry();

    private Executor executor;

    /**
     * MoreExecutors.directExecutor() 是 Google Guava 提供的工具类，看似是多线程，
     * 实际上是单线程。之所以要这么实现，主要还是为了跟 AsyncEventBus统一代码逻辑，做到代码复用。
     */
    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }


    // 注册
    public void register(Object observer) {
        registry.register(observer);
    }

    // 发送Event事件
    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        observerActions.forEach(observerAction -> {
            observerAction.execute(event);
        });
    }
}
