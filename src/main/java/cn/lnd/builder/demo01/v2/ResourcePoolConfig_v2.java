package cn.lnd.builder.demo01.v2;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author lnd
 * @Description
 * @Date 2022/9/21 15:57
 */
public class ResourcePoolConfig_v2 {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig_v2(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    /*
        这里将Builder类设计成了 ResourcePoolConfig_v2 的静态内部类
        我们也可以将 Builder 类设计成独立的非内部类 ResourcePoolConfigBuilder
        */
    public static class Builder {
        //常量
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        //成员变量
        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE; //最大空闲资源数量
        private int minIdle = DEFAULT_MIN_IDLE; //最小空闲资源数量

        /*
         * 在正式创建对象之前对接收到的所有参数做统一处理。
         * */
        public ResourcePoolConfig_v2 build() {
            //校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等。
            //因为在执行build之前，所有的参数已经传递完毕，就可以对所有参数进行校验了
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }

            return new ResourcePoolConfig_v2(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.minIdle = minIdle;
            return this;
        }
    }

    static class MainApp {

    }
}


/*
静态内部类与普通类的区别只是它 1、加载的时机不同 2、初始化的时机不同 3、在代码中使用时的方式不同
其它与普通类并无区别，静态内部类里面还可以声明 static 变量，也可以使用 this 对象，this 表示的是这个静态内部类的实例对象，与外部类无关
*/