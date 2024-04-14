package geek._49.demo02;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 20:21
 */
@Slf4j
public class EmailMsgSender implements MsgSender{

    private List<String> emailAddresses;


    public EmailMsgSender(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public void send(String message) {
        for (String email : emailAddresses) {
            // ...
            log.info("send to email:{} msg:{}", email, message);
        }
    }
}
