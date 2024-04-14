package geek._18.demo03;

import lombok.Data;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/1 20:19
 */
@Data
public class KafkaConfig implements Updater {
    private ConfigSource configSource; // 配置中心（比如 zookeeper）
    private String address;
    private int timeout;
    private int maxTotal;
    // 省略其他配置: maxWaitMillis,maxIdle,minIdle...

    public KafkaConfig(ConfigSource configSource) {
        this.configSource = configSource;
    }

    @Override
    public void update() {
        // 从 configSource 加载配置到 address/timeout/maxTotal...
    }
}
