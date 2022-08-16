package cn.lnd.observer.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/15 23:03
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
