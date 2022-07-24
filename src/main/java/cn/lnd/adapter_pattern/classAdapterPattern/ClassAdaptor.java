package cn.lnd.adapter_pattern.classAdapterPattern;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/21 19:23
 */
/*
    适配器
        1、要把上游适配成下游。所以要实现下游接口的标准，即实现下游接口
        2、但实际上真正执行的还是上游对象中的方法，所以可以实现上游的类（即 Adaptee），并调用类中的方法
        3、如果有需要，还可以重新实现这些方法
*/
public class ClassAdaptor extends Adaptee implements ITarget{


    @Override
    public void f1() {
        // 调用上游类中的方法
        super.fa();
    }

    @Override
    public void f2() {
        // TODO 重新实现 f2()
        System.out.println("f2New");
    }

    // 这里 fc() 不需要实现，因为 fc() 方法直接继承自 Adaptee，在父类中已经存在了，所以可以不必重新实现一次。
    // 这是跟对象适配器最大的不同点。
}
