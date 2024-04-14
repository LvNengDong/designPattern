package geek._19.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/1 21:08
 */
public abstract class TestCase {
    public void run() {
        if (doTest()) {
            System.out.println("Test succeed.");
        } else {
            System.out.println("Test failed.");
        }
    }

    public abstract boolean doTest();
}
