package cn.lnd.adapterPattern.objectAdapterPattern;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/21 19:34
 */
public class ObjectAdaptor implements ITarget{

    private Adaptee adaptee;

    public ObjectAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa(); // 委托给 Adaptee
    }

    @Override
    public void f2() {
        // 可以重新实现 f2()
    }

    @Override
    public void f3() {
        adaptee.fc();
    }
}
