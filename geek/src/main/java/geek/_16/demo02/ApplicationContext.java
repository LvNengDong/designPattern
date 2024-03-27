package geek._16.demo02;

import geek._16.demo01.AlertRule;
import geek._16.demo01.Notification;
import lombok.Getter;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 23:56
 */
public class ApplicationContext {
    AlertRule alertRule;
    Notification notification;
    @Getter
    Alert_V2 alert;

    // 饿汉式单例
    @Getter
    private static final ApplicationContext instance;

    static {
        instance = new ApplicationContext();
        instance.initBeans();
    }

    // 私有构造函数，防止外部创建实例
    private ApplicationContext() {

    }

    public void initBeans() {
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert_V2();
        // 注册 Handler
        alert.addAlertHandler(new TpsAlertHander(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
    }
}
