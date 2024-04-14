package geek._49.demo02;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 20:21
 */
@Slf4j
public class TelephoneMsgSender implements MsgSender{

    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        for (String telephone : telephones) {
            // ...
            log.info("send to phone:{} msg:{}", telephone, message);
        }
    }
}
