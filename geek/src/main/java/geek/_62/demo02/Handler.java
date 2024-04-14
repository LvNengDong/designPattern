package geek._62.demo02;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/7 23:10
 */
public abstract class Handler {
    // 下一个处理器
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void handle() {
        boolean handled = doHandle();
        // handled是返回结果，true表示处理成功，false表示处理失败
        if (!handled && successor != null) {
            successor.handle();
        }
    }
    public abstract boolean doHandle();
}
