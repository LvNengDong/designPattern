package geek._56.demo01;


/**
 * @Author lnd
 * @Description 被观察者
 * @Date 2024/3/22 11:53
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Message message);
}
