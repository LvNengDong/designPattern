package geek._56.demo02.observer;

/**
 * @Author lnd
 * @Description 注册成功事件的Observer
 * @Date 2024/3/22 12:52
 */
public interface RegObserver {
    void handleRegSuccess(long userId);
}
