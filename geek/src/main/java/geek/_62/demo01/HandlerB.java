package geek._62.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/7 23:12
 */
public class HandlerB extends Handler{
    @Override
    public void handle() {
        boolean handled = false;
        // ...
        System.out.println("HandlerB handle...");
        // 如果 HandlerB 可以处理该请求，就将 handled 的值置为 true，这样请求就不会交给下一个Handler处理器了
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
