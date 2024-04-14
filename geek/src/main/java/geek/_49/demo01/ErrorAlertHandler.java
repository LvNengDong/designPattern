package geek._49.demo01;

import geek._16.demo01.AlertRule;
import geek._16.demo01.NotifcationEmergencyLevel;
import geek._16.demo01.Notification;
import geek._16.demo02.AlertHandler;
import geek._16.demo02.ApiStatInfo;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 20:16
 */
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrCount()) { //错误量大于预设错误量阈值
            notification.notify(NotifcationEmergencyLevel.SEVERE, "...");
        }
    }
}
