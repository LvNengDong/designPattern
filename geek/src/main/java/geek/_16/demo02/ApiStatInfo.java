package geek._16.demo02;

import lombok.Data;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 23:34
 */
@Data
public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errCount;
    private long durationOfSeconds = 1;
    private long timeoutCount;
}
