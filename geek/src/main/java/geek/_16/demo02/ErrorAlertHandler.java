package geek._16.demo02;

import geek._16.demo01.AlertRule;
import geek._16.demo01.NotifcationEmergencyLevel;
import geek._16.demo01.Notification;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 23:38
 */
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        String api = apiStatInfo.getApi();
        long errCount = apiStatInfo.getErrCount();
        // 错误请求次数大于api规定的最大错误请求次数
        if (errCount > rule.getMatchedRule(api).getMaxErrCount()) {
            notification.notify(NotifcationEmergencyLevel.URGENCY, "...");
        }
    }
}
