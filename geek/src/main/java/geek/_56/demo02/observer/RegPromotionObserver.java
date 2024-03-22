package geek._56.demo02.observer;

import geek._56.demo02.service.PromotionService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 12:53
 */
@Slf4j
public class RegPromotionObserver implements RegObserver {

    private final PromotionService promotionService = new PromotionService();

    @Override
    public void handleRegSuccess(long userId) {
        log.info("监听到用户[{}]注册成功，发放新客优惠券", userId);
        promotionService.issueNewUserExperienceCash(userId);
    }
}
