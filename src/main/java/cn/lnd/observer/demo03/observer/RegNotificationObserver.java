package cn.lnd.observer.demo03.observer;

import cn.lnd.observer.demo03.service.NotificationService;
import com.google.common.eventbus.Subscribe;

/**
 * @Author lnd
 * @Description 监听者：注册成功后向新用户发送邮件
 * @Date 2022/9/20 19:33
 */
public class RegNotificationObserver {
    private NotificationService notificationService = new NotificationService();

    /*通过这个注解来标明类中哪个函数可以接收观察者发送的消息*/
    @Subscribe
    public void handleRegSuccess(long userId){
        notificationService.sendInboxMessage(userId, "....");
    }
}
