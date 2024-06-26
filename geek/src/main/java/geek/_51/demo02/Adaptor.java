package geek._51.demo02;

import geek._51.demo01.Adaptee;
import geek._51.demo01.ITarget;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 15:55
 */
public class Adaptor implements ITarget {

    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa(); // 委托给adaptee
    }

    @Override
    public void f2() {
        // ...重新实现f2()...
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
