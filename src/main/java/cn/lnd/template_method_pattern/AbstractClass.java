package cn.lnd.template_method_pattern;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 20:31
 */
public abstract class AbstractClass {

    /**
     * 模板方法定义为 final，是为了避免子类重写它。
     */
    public final void templateMethod(){
        method1();
        method2();
        // ...
    }

    protected abstract void method1();
    protected abstract void method2();
}
