package geek._56.demo02.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 13:02
 */
@Slf4j
public class NotificationService {

    public void sendInboxMessage(long userId) {
        log.info("用户[{}]注册成功，发送Welcome消息", userId);
    }
}
