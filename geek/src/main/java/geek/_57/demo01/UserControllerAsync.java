package geek._57.demo01;

import geek._56.demo02.observer.RegObserver;
import geek._56.demo02.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Author lnd
 * @Description 进程内异步版本
 * @Date 2024/3/22 13:09
 */
public class UserControllerAsync {

    private UserService userService = new UserService();
    private List<RegObserver> regObservers = new ArrayList<RegObserver>();
    private final Executor executor;

    public UserControllerAsync(Executor executor) {
        this.executor = executor;
    }

    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public long register(String phone, String password) {
        // 省略输入参数的校验代码
        // 省略 userService.register() 异常的try-catch代码
        final long userId = userService.register(phone, password);

        for (final RegObserver regObserver : regObservers) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    regObserver.handleRegSuccess(userId);
                }
            });
        }
        return userId;
    }
}
