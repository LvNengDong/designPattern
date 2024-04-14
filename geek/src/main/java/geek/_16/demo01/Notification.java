package geek._16.demo01;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author lnd
 * @Description Notification 是告警通知类，支持邮件、短信、微信、手机等多种通知渠道
 * @Date 2024/3/22 23:03
 */
@Slf4j
@NoArgsConstructor
@Data
public class Notification {
    private List<String> emailAddresses;
    private List<String> telephones;
    private List<String> wechatIds;

    public void notify(NotifcationEmergencyLevel level, String message) {
        if (level.equals(NotifcationEmergencyLevel.SEVERE)) {
            //...自动语音电话
            log.info("电话通知:{}", message);
        } else if (level.equals(NotifcationEmergencyLevel.URGENCY)) {
            //...发微信
            log.info("微信通知:{}", message);
        } else if (level.equals(NotifcationEmergencyLevel.NORMAL)) {
            //...发邮件
            log.info("邮件通知:{}", message);
        } else if (level.equals(NotifcationEmergencyLevel.TRIVIAL)) {
            //...发邮件
            log.info("邮件通知:{}", message);
        }
    }
}
