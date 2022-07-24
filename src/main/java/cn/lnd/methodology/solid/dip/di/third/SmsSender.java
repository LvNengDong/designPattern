package cn.lnd.methodology.solid.dip.di.third;

/**
 * @Author lnd
 * @Description 短信发送类
 * @Date 2022/7/24 23:38
 */
public class SmsSender implements MessageSender{
    @Override
    public void send(String cellphone, String message) {
        // TODO 发送短信
    }
}
