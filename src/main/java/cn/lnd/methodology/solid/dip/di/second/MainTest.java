package cn.lnd.methodology.solid.dip.di.second;

import cn.lnd.methodology.solid.dip.di.first.MessageSender;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 23:27
 */
public class MainTest {
    public static void main(String[] args) {
        // 使用 Notification
        MessageSender messageSender = new MessageSender();
        Notification notification = new Notification(messageSender);
    }
}
