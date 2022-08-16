package cn.lnd.observer.demo02.v03;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/17 0:31
 *
 * 分离观察者与被观察者
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
        /*
            >> push的方式，由被观察者将事件推送给观察者。
            >> 这就要求被观察者必须持有它所有的观察者集合
        */
        for (Observer observer : observers) {
            observer.actionOnWakeUp();
        }
    }
}

// 观察者接口
interface Observer{
    void actionOnWakeUp();
}

// 观察者一
class Dad implements Observer{

    public void hug(){
        System.out.println("dad hugging...");
    }

    /*
        观察者观察到事件发生后（小孩醒了）的处理逻辑
    */
    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

// 观察者二
class Mom implements Observer{
    public void feed(){
        System.out.println("mom feeding...");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

// 观察者三
class Dog implements Observer{
    public void wang(){
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}


public class Main03 {
    public static void main(String[] args) {
        Child child = new Child();
        // do sth
        child.wakeUp();  // child 睡醒了
    }
}
