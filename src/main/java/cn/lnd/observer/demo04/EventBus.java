package cn.lnd.observer.demo04;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Author lnd
 * @Description EventBus实现的是阻塞同步的观察者模式
 * @Date 2022/9/20 20:31
 */
public class EventBus {
    /**
     * EventBus实现的是阻塞同步的观察者模式。
     * 实际上，MoreExecutors.directExecutor() 是 Guava 提供的工具类，看似是多线程，实际上是单线程，
     * 之所以要这么实现（使用线程池Executor），主要是为了跟 AsyncEventBus 统一代码逻辑，做到代码复用。
     */
    private Executor executor;

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    private ObserverRegistry registry = new ObserverRegistry();

    public void register(Object object) {
        registry.register(object);
    }


    /**
     * 当被观察者调用 post() 函数发送消息的时候，EventBus 通过注册表找到相应的可接收消息的函数，然后通过Java的反射语法来动态地创建对象，执行函数
     * @param event
     */
    public void post(Object event){
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
