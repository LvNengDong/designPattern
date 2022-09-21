package cn.lnd.builder.demo01;


import org.apache.commons.lang3.StringUtils;

/**
 * @Author lnd
 * @Description
 * @Date 2022/9/21 15:16
 */
public class ResourcePoolConfig {
    /*常量*/
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE; //最大空闲资源数量
    private int minIdle = DEFAULT_MIN_IDLE; //最小空闲资源数量


    public ResourcePoolConfig(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;

        if (maxTotal != null) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
        }

        if (maxIdle != null) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.maxIdle = maxIdle;
        }

        if (minIdle != null) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should not be negative.");
            }
            this.minIdle = minIdle;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}
