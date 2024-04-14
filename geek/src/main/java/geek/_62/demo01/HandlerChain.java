package geek._62.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/7 23:17
 */
public class HandlerChain {

    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        // 初始化：清除历史遗留数据
        handler.setSuccessor(null);

        if (head == null) {
            head = handler;
            tail = handler;
            return;
        } else {
            tail.setSuccessor(handler);
            tail = handler;
        }
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
