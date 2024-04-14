package geek._48.demo03;

import geek._26.demo01.MetricsCollector;
import geek._48.demo02.UserController;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/13 13:47
 */
public class Application {
    public static void main(String[] args) {
        //UserControllerProxy使用举例
        UserController userController = new UserControllerProxy(new MetricsCollector());
    }
}
