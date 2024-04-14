package geek._48.demo04;

import geek._48.demo02.IUserController;
import geek._48.demo02.UserController;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/13 14:05
 */
public class Application {
    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
    }
}
