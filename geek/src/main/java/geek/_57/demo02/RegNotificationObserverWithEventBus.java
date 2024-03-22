package geek._57.demo02;

import com.google.common.eventbus.Subscribe;
import geek._56.demo02.service.NotificationService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 13:01
 */
@Slf4j
public class RegNotificationObserverWithEventBus {
    private NotificationService notificationService = new NotificationService();

    @Subscribe
    public void handleRegSuccess(long userId) {
        log.info("监听到用户[{}]注册成功，发送Welcome消息", userId);
        notificationService.sendInboxMessage(userId);
    }
}
