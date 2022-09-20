package cn.lnd.observer.demo03.service;

/**
 * @Author lnd
 * @Description
 * @Date 2022/9/20 19:31
 */
public class NotificationService {

    public void sendInboxMessage(long userId, String s){
        System.out.println("向新用户" + userId + "发送邮件：" + s);
    }
}
