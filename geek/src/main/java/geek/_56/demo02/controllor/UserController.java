package geek._56.demo02.controllor;

import geek._56.demo02.observer.RegObserver;
import geek._56.demo02.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 13:09
 */
public class UserController {

    private UserService userService = new UserService();

    private List<RegObserver> regObservers = new ArrayList<RegObserver>();

    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public long register(String phone, String password) {
        // 省略输入参数的校验代码
        // 省略 userService.register() 异常的try-catch代码
        long userId = userService.register(phone, password);

        for (RegObserver regObserver : regObservers) {
            regObserver.handleRegSuccess(userId);
        }

        return userId;
    }
}
