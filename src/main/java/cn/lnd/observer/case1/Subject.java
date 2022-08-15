package cn.lnd.observer.case1;

import java.util.List;

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
