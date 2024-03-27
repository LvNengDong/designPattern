package geek._60.demo02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author lnd
 * @Description 运行时动态确定，根据配置文件的配置决定使用哪种策略
 * @Date 2024/3/27 21:30
 */
public class Application_v2 {
    public static void main(String[] args) throws IOException {
        EvictionStrategy evictionStrategy = null;
        Properties props = new Properties();
        props.load(new FileInputStream("./config.properties"));
        String type = props.getProperty("eviction_type");
        evictionStrategy = EvictionStrategyFactory.getEvictionStrategy(type);
        UserCache userCache = new UserCache(evictionStrategy);
        //...
    }
}
