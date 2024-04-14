package geek._69.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 14:26
 */
public class DemoMain {
    public static void main(String[] args) {
        SingleDispatchClass demo = new SingleDispatchClass();
        ParentClass p = new ChildClass();
        demo.polymorphismFunction(p); //执行对象的哪个方法，由对象的实际类型决定
        demo.overloadFunction(p); //执行对象的哪个方法，由参数对象的声明类型决定
    }
}
