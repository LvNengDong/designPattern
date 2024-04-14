package geek._26.demo01;

import lombok.Data;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/2 21:19
 */
@Data
public class RequestStat {
    private double maxResponseTime;
    private double minResponseTime;
    private double avgResponseTime;
    private double p999ResponseTime;
    private double p99ResponseTime;
    private long count;
    private long tps;
    //... 省略 getter/setter 方法...
}
