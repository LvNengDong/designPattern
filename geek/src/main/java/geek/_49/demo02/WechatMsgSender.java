package geek._49.demo02;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 20:21
 */
@Slf4j
public class WechatMsgSender implements MsgSender{

    private List<String> wechatIds;


    public WechatMsgSender(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }

    @Override
    public void send(String message) {
        for (String wechatId : wechatIds) {
            // ...
            log.info("send to wechatIds:{} msg:{}", wechatIds, message);
        }
    }
}
