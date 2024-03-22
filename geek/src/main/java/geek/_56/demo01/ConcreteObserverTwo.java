package geek._56.demo01;


/**
 * @Author lnd
 * @Description 观察者实例2
 * @Date 2024/3/22 12:01
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        // TODO：收到消息通知，执行自己的逻辑
        System.out.println("ConcreteObserverTwo is notified...");
        System.out.println("message is >> " + message);
    }
}
