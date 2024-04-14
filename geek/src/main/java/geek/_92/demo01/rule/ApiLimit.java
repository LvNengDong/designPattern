package geek._92.demo01.rule;

import lombok.Data;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 23:53
 */
@Data
public class ApiLimit {
    public static final int DEFAULT_TIME_UNIT = 1; // 1s

    private String api;
    private int limit;
    private int unit = DEFAULT_TIME_UNIT;

    public ApiLimit() {
    }

    public ApiLimit(String api, int limit) {
        this(api, limit, DEFAULT_TIME_UNIT);
    }

    public ApiLimit(String api, int limit, int unit) {
        this.api = api;
        this.limit = limit;
        this.unit = unit;
    }
}
