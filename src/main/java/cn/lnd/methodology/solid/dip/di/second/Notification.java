package cn.lnd.methodology.solid.dip.di.second;

import cn.lnd.methodology.solid.dip.di.first.MessageSender;

/**
 * @Author lnd
 * @Description DI的实现方式
 * @Date 2022/7/24 23:25
 */
public class Notification {

    private MessageSender messageSender;

    // 通过构造函数将 messageSender 传进来
    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellphone, String message){
        // 省略校验逻辑等
        this.messageSender.send(cellphone, message);
    }
}
