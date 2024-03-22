package geek._56.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description 具体被观察者
 * @Date 2024/3/22 11:56
 */
public class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<Observer>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
