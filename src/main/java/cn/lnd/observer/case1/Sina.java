package cn.lnd.observer.case1;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/15 23:21
 */
public class Sina implements Observer{
    private String temperature;
    private String weather;
    private String airQuality;

    /**
     * 该方法由气象站来调用，当气象站天气数据发生变化时，就会调用该方法推送最新的数据给第三方平台
     *
     * @param temperature
     * @param weather
     * @param airQuality
     */
    @Override
    public void update(String temperature, String weather, String airQuality) {
        // 同步气象站发布的实时天气数据
        this.temperature = temperature;
        this.weather = weather;
        this.airQuality = airQuality;
    }


    /**
     * 数据展示
     */
    public void show()
    {
        System.out.println("新浪天气（温度）" + this.temperature);
        System.out.println("新浪天气（天气）" + this.weather);
        System.out.println("新浪天气（空气质量）" + this.airQuality);
    }
}

