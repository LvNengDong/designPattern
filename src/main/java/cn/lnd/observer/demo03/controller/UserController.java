package cn.lnd.observer.demo03.controller;

import cn.lnd.observer.demo03.service.UserService;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @Author lnd
 * @Description 被观察者：所有的观察者都在观察用户注册成功这一事件
 * @Date 2022/9/20 19:15
 */
public class UserController {

    private UserService userService = new UserService();

    private EventBus eventBus;

    public static final int POOL_SIZE = 20;

    public UserController() {
        this.eventBus = new EventBus(); //同步阻塞模式
        //this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(POOL_SIZE));
    }


    /*把观察者放入EventBus*/
    public void setRegObservers(List<Object> observers){
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String password){
        long userId = userService.register(telephone, password);

        // 向观察者发送事件发生的消息
        /*和传统的观察者模式不同的是：当我们调用post函数发送消息的时候，并非把消息发送给所有的观察者，而是发送给可匹配的观察者。
        * “可匹配”是指：*/
        eventBus.post(userId);
        return userId;
    }
}
