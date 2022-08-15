package cn.lnd.observer.case1;

/**
 * @Author lnd
 * @Description 观察者
 * @Date 2022/8/15 23:05
 */
public interface Observer {
    void update(String temperature, String weather, String airQuality);
}
