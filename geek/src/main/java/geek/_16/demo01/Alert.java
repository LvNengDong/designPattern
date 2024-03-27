package geek._16.demo01;

import lombok.AllArgsConstructor;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 23:04
 */
@AllArgsConstructor
public class Alert {
    private AlertRule rule;
    private Notification notification;

    public void check(String api, long requestCount, long errCount, long durationOfSeconds) {
        // 实时tps大于api规定的最大tps
        long tps = requestCount / durationOfSeconds;
        if (tps > rule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotifcationEmergencyLevel.URGENCY, "...");
        }
        // 错误请求次数大于api规定的最大错误请求次数
        if (errCount > rule.getMatchedRule(api).getMaxErrCount()) {
            notification.notify(NotifcationEmergencyLevel.URGENCY, "...");
        }
    }
}
