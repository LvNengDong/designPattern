package cn.lnd.methodology.solid.dip.di.first;

/**
 * @Author lnd
 * @Description 非DI的实现方式
 * @Date 2022/7/24 23:15
 */
public class Notification {

    private MessageSender messageSender;

    public Notification() {
        this.messageSender = new MessageSender();
    }

    public void sendMessage(String cellphone, String message){
        // 省略校验逻辑等
        this.messageSender.send(cellphone, message);
    }
}
