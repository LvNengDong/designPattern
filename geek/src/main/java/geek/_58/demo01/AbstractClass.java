package geek._58.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/6 22:32
 */
public abstract class AbstractClass {

    /**
     * 定义为 final，是为了避免子类重写它
     */
    public final void templateMethod() {
        method1();    
        method2();
        // ...
    }

    /**
     * 定义为 abstract，是为了强迫子类去实现
     */
    protected abstract void method1();

    protected abstract void method2();
}
