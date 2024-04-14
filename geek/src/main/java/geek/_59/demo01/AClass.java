package geek._59.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/6 23:19
 */
public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();
        b.process(new ICallBack() { //回调对象
            @Override
            public void methodToCallBack() {
                System.out.println("Call back me.");
            }
        });
    }
}
