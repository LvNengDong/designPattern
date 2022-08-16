package cn.lnd.observer.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/15 23:23
 */
public class MainApp {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        // 第三方平台订阅气象台的天气服务
        Sina sina = new Sina();
        weatherData.registerObserver(sina);

        // Subject 实时更新数据
        // setData方法底层会自动同步最新数据给所有订阅了天气服务的第三方平台
        weatherData.setData("25℃", "晴", "良");


        // 【测试】第三方平台展示数据测试
        sina.show();
        System.out.println("===================");

    }
}
