package cn.lnd.observer.demo02.v02;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/17 0:16
 *
 * 加入观察者
 */
class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mom mom = new Mom();
    private Dog dog = new Dog();

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
        dad.hug();
        mom.feed();
        dog.wang();
    }
}
// 观察者一
class Dad{
    /*
        观察者观察到事件发生后（小孩醒了）的处理逻辑
    */
    public void hug(){
        System.out.println("dad hugging...");
    }
}

// 观察者二
class Mom{
    public void feed(){
        System.out.println("mom feeding...");
    }
}

// 观察者三
class Dog{
    public void wang(){
        System.out.println("dog wang...");
    }
}


public class Main02 {
    public static void main(String[] args) {
        Child child = new Child();
        // do sth
        child.wakeUp();  // child 睡醒了
    }
}

