package cn.lnd.adapterPattern.classAdapterPattern;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/21 19:22
 */
// 适配器上游接口：要被适配的类
public class Adaptee {

    public void fa(){
        System.out.println("fa");
    }

    public void fb(){
        System.out.println("fb");
    }

    public void fc(){
        System.out.println("fc");
    }
}
