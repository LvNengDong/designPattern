package geek._49.demo02;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 20:27
 */
public class SevereNotification extends Notification {

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
