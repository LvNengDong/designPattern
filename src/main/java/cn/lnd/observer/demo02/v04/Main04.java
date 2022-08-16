package cn.lnd.observer.demo02.v04;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/17 0:40
 *
 * >> 有很多时候，观察者需要根据事件的具体情况（事件的程度、事件等）来进行分开处理，
 * 所以观察者往往需要拿到事件（Event）对象.
 * >> 如何拿到Event对象——传参
 */
// 被观察者
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
    }


    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("Wake up! Crying wuwuwu...");
        cry = true;
        // 事件的抽象
        WakeUpEvent bed = new WakeUpEvent(System.currentTimeMillis(), "bed");
        /*
            >> push的方式，由被观察者将事件推送给观察者。
            >> 这就要求被观察者必须持有它所有的观察者集合
        */
        for (Observer observer : observers) {
            // 将事件 Event 作为入参传递给观察者
            observer.actionOnWakeUp(bed);
        }
    }
}
// 事件类
class WakeUpEvent{
    // 描述 child 何时从何地醒来
    long timestamp;
    String adress;

    public WakeUpEvent(long timestamp, String adress) {
        this.timestamp = timestamp;
        this.adress = adress;
    }
}

interface Observer{
    void actionOnWakeUp(WakeUpEvent event);
}

// 观察者一
class Dad implements Observer {

    public void hug(){
        System.out.println("dad hugging...");
    }

    /*
        观察者观察到事件发生后（小孩醒了）的处理逻辑
    */
    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        // TODO 根据 event 中 child 醒来的时间、醒来的地点做不同的处理
        hug();
    }
}

// 观察者二
class Mom implements Observer {
    public void feed(){
        System.out.println("mom feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}

// 观察者三
class Dog implements Observer {
    public void wang(){
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        wang();
    }
}

public class Main04 {
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}

