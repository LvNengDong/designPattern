package cn.lnd.observer.demo02.v01;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/17 0:07
 *
 * 傻等
 */
public class Main01 {

    public static void main(String[] args) throws InterruptedException {

        Child child = new Child();
        /*
            监听器处于一种傻等状态，当有其它线程唤醒 child 后，
            监听器处理 child 醒后的逻辑
        */
        while (!child.isCry()){
            Thread.sleep(1000);
            System.out.println("监听中...");
        }

        System.out.println("小孩醒了，给他喂奶");
    }
}

class Child {
    private boolean cry = false;

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("Wake up! Crying wuwuwu...");
        cry = true;
    }
}