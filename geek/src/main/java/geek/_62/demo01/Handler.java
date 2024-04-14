package geek._62.demo01;

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

    public abstract void handle();
}
