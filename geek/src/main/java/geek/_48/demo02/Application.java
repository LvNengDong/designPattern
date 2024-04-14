package geek._48.demo02;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/13 13:37
 */
public class Application {
    public static void main(String[] args) {
        //UserControllerProxy使用举例

        //因为原始类和代理类实现相同的接口，是基于接口而非实现编程
        //将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
        IUserController userController = new UserControllerProxy(new UserController(), new MetricsCollector());
        userController.login("zhangsan", "123456");
    }
}
