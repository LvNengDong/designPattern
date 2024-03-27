package geek._16.demo02;

import geek._16.demo01.AlertRule;
import geek._16.demo01.Notification;
import lombok.AllArgsConstructor;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 23:41
 */
@AllArgsConstructor
public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;
    public abstract void check(ApiStatInfo apiStatInfo);
}
