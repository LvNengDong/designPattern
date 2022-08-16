package cn.lnd.observer.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/15 23:07
 */
public class WeatherData implements Subject{

    private String temperature; // 温度
    private String weather; // 天气（晴/阴/雨）
    private String airQuality;  // 空气质量
    private List<Observer> observerList = new ArrayList<>(); // 用于维护观察者列表

    /**
     * 注册观察者 Observer（新增）
     */
    @Override
    public void registerObserver(Observer observer)
    {
        if (observerList.contains(observer)) {
            throw new RuntimeException("该观察者已存在");
        }
        observerList.add(observer);
    }

    /**
     * 删除某个观察者Observer
     */
    @Override
    public void removeObserver(Observer observer)
    {
        if (!observerList.contains(observer)) {
            throw new RuntimeException("该观察者不是一个合法的观察者");
        }
        observerList.remove(observer);
    }

    /**
     * 通知所有订阅服务的观察者
     */
    @Override
    public void notifyObservers()
    {
        for (Observer observer : observerList) {
            observer.update(this.temperature, this.weather, this.airQuality);
        }
    }

    /**
     * 实时更新数据，并将实时数据推送给所有订阅了天气服务的第三方平台
     * （这就要求气象台在发生数据变更时必须强制执行这个方法，我们可以
     * 不提供其它单个属性的 set 方法，强制要求更新数据时必须同时更新这三个属性）
     * @param temperature
     * @param weather
     * @param airQuality
     */
    public void setData(String temperature, String weather, String airQuality)
    {
        // 实时更新数据
        this.temperature = temperature;
        this.weather = weather;
        this.airQuality = airQuality;
        // 将实时数据通知到所有订阅天气服务的第三方平台
        this.notifyObservers();
    }


    public List<Observer> getObserverList() {
        return observerList;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWeather() {
        return weather;
    }

    public String getAirQuality() {
        return airQuality;
    }

}
