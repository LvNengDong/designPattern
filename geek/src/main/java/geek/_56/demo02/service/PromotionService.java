package geek._56.demo02.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 12:55
 */
@Slf4j
public class PromotionService {

    public void issueNewUserExperienceCash(long userId) {
        log.info("用户[{}]注册成功，发放新客优惠券", userId);
    }
}
