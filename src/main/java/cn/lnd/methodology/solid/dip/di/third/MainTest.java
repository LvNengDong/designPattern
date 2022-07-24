package cn.lnd.methodology.solid.dip.di.third;


/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 23:41
 */
public class MainTest {

    public static void main(String[] args) {
        // 使用 Notification
        MessageSender messageSender = new SmsSender(); // 创建对象
        Notification notification1 = new Notification(messageSender); // 依赖注入
        notification1.sendMessage("13998752418", "短信验证码：257885");
    }
}
