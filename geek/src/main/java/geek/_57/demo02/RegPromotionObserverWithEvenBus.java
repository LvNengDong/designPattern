package geek._57.demo02;

import com.google.common.eventbus.Subscribe;
import geek._56.demo02.service.NotificationService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 16:55
 */
@Slf4j
public class RegPromotionObserverWithEvenBus {
    private final NotificationService notificationService = new NotificationService();

    @Subscribe // EventBus相关注解
    public void handleRegSuccess(long userId) {
        log.info("监听到用户[{}]注册成功，发送Welcome消息", userId);
        notificationService.sendInboxMessage(userId);
    }
}
