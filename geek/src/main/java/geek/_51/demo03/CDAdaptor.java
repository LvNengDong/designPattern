package geek._51.demo03;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 16:03
 */
public class CDAdaptor extends CD implements ITarget {
    @Override
    public void function1() {
        super.staticFunction1();
    }

    @Override
    public void function2() {
        super.uglyNamingFunction2();
    }

    @Override
    public void fucntion3(ParamsWrapperDefinition paramsWrapper) {
        super.tooManyParamsFunction3(paramsWrapper.getParamA(), paramsWrapper.getParamB());
    }

    @Override
    public void function4() {
        //...reimplement it...
    }
}
