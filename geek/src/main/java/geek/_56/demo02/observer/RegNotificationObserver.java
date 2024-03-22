package geek._56.demo02.observer;

import geek._56.demo02.service.NotificationService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 13:01
 */
@Slf4j
public class RegNotificationObserver implements RegObserver {
    private NotificationService notificationService = new NotificationService();
    @Override
    public void handleRegSuccess(long userId) {
        log.info("监听到用户[{}]注册成功，发送Welcome消息", userId);
        notificationService.sendInboxMessage(userId);
    }
}
