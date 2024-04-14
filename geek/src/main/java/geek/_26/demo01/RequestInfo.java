package geek._26.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/2 21:11
 */
@AllArgsConstructor
@Data
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;
    //... 省略 constructor/getter/setter 方法...
}
