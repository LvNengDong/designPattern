package cn.lnd.observer.demo03;

import cn.lnd.observer.demo03.controller.UserController;
import cn.lnd.observer.demo03.observer.RegNotificationObserver;
import cn.lnd.observer.demo03.observer.RegPromotionObserver;
import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @Author lnd
 * @Description
 * @Date 2022/9/20 20:06
 */
public class MainApp {
    public static void main(String[] args) {
        UserController userController = new UserController();
        //把观察者放入EventBus中
        RegNotificationObserver regNotificationObserver = new RegNotificationObserver();
        RegPromotionObserver regPromotionObserver = new RegPromotionObserver();
        ArrayList<Object> list = Lists.newArrayList();
        list.add(regNotificationObserver);
        list.add(regPromotionObserver);
        userController.setRegObservers(list);
        //新用户注册，注册后会触发观察者事件
        Long userId = userController.register("13112885342", "0858");
    }
}
