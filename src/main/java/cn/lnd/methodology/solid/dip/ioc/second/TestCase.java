package cn.lnd.methodology.solid.dip.ioc.second;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:42
 */
public abstract class TestCase {
    public void run() {
        if (doTest()){ // doTest()是测试代码运行的结果，成功或失败
            System.out.println("Test succeed");
        }else {
            System.out.println("Test failed");
        }
    }

    protected abstract boolean doTest();
}
