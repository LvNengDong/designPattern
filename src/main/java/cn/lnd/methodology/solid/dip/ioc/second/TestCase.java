package cn.lnd.methodology.solid.dip.ioc.second;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:42
 */
public abstract class TestCase {
    public void run() {
        if (doTest()){
            System.out.println("Test succeed");
        }else {
            System.out.println("Test failed");
        }
    }

    protected abstract boolean doTest();
}
