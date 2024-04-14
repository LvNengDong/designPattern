package geek._58.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/6 22:35
 */
public class ConcreteClass1 extends AbstractClass{
    @Override
    protected void method1() {
        System.out.println("ConcreteClass1#method1 执行");
    }

    @Override
    protected void method2() {
        System.out.println("ConcreteClass1#method2 执行");
    }
}
