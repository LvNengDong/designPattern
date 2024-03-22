package geek._56.demo01;


/**
 * @Author lnd
 * @Description 测试用例
 * @Date 2024/3/22 12:02
 */
public class Demo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        // 注册观察者
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        // 通知观察者
        subject.notifyObservers(new Message("Order status changed"));
    }
}
