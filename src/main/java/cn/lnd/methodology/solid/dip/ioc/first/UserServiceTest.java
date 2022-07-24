package cn.lnd.methodology.solid.dip.ioc.first;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:36
 */
public class UserServiceTest {

    public static boolean doTest(){
        // return true or false
        return true;
    }

    public static void main(String[] args) {
        if (doTest()){
            System.out.println("Test succeed");
        }else {
            System.out.println("Test failed");
        }
    }
}
