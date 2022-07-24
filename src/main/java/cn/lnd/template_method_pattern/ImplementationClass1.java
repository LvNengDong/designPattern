package cn.lnd.template_method_pattern;

import java.io.InputStream;

/**
 * @Author lnd
 * @Description 实现类
 * @Date 2022/7/24 20:33
 */
public class ImplementationClass1 extends AbstractClass{

    @Override
    protected void method1() {

        System.out.println("ImplementationClass1#method1");
    }

    @Override
    protected void method2() {
        System.out.println("ImplementationClass1#method2");
    }
}
