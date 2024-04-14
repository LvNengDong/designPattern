package geek._49.demo02;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 20:26
 */
public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}
