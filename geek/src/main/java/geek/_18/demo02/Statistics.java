package geek._18.demo02;

import lombok.Data;

import java.util.Collection;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/1 20:12
 */
@Data
public class Statistics {
    private Long max;
    private Long min;
    private Long average;
    private Long sum;
    private Long percentile99;
    private Long percentile999;
    //... 省略 constructor/getter/setter 等方法...

    public Statistics count(Collection<Long> dataSet) {
        Statistics statistics = new Statistics();
        //... 省略计算逻辑...
        return statistics;
    }
}
