package cn.lnd.template_method_pattern;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 20:35
 */
public class MainApp {


    public static void main(String[] args) {
        AbstractClass class1 = new ImplementationClass1();
        class1.templateMethod();
    }
    /* 执行以上代码，输出结果为：
    --------------------------------------
    ImplementationClass1#method1
    ImplementationClass1#method2
    ----------------------------------- */
}
