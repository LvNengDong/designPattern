package geek._69.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 14:24
 */
public class SingleDispatchClass {
    // 多态函数
    public void polymorphismFunction(ParentClass p) {
        p.f();
    }
    // 重载方法
    public void overloadFunction(ParentClass p) {
        System.out.println("I am overloadFunction(ParentClass p).");
    }
    // 重载方法
    public void overloadFunction(ChildClass c) {
        System.out.println("I am overloadFunction(ChildClass c).");
    }
}
