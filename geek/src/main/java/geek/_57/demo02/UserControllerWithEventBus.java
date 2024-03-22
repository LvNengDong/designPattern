package geek._57.demo02;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import geek._56.demo02.observer.RegObserver;
import geek._56.demo02.service.UserService;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 16:43
 */
public class UserControllerWithEventBus {

    private final UserService userService = new UserService();

    private EventBus eventBus;

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserControllerWithEventBus() {
        //eventBus = new EventBus(); //同步阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE)); // 异步非阻塞模式
    }

    public void setRegObservers(List<RegObserver> observers) {
        observers.forEach(observer -> {
            // 注册Observer
            eventBus.register(observers);
        });
    }

    public long register(String phone, String password) {
        // 省略输入参数的校验代码
        // 省略 userService.register() 异常的try-catch代码
        long userId = userService.register(phone, password);
        // 给Observer发送Event事件
        eventBus.post(userId);
        return userId;
    }
}
