package geek._16.demo02;

import geek._16.demo01.AlertRule;
import geek._16.demo01.NotifcationEmergencyLevel;
import geek._16.demo01.Notification;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 23:38
 */
public class TpsAlertHander extends AlertHandler {

    public TpsAlertHander(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        // 实时tps大于api规定的最大tps
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(NotifcationEmergencyLevel.URGENCY, "...");
        }
    }
}
