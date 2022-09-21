package cn.lnd.builder.demo01;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author lnd
 * @Description
 * @Date 2022/9/21 15:40
 */
public class ResourcePoolConfig_v1 {
    /*常量*/
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE; //最大空闲资源数量
    private int minIdle = DEFAULT_MIN_IDLE; //最小空闲资源数量

    public ResourcePoolConfig_v1(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;
    }


    public void setMaxTotal(int maxTotal) {
        if (maxTotal <= 0) {
            throw new IllegalArgumentException("maxTotal should be positive.");
        }
        this.maxTotal = maxTotal;
    }

    public void setMaxIdle(int maxIdle) {
        if (maxIdle < 0) {
            throw new IllegalArgumentException("maxIdle should not be negative.");
        }
        this.maxIdle = maxIdle;
    }

    public void setMinIdle(int minIdle) {
        if (minIdle < 0) {
            throw new IllegalArgumentException("minIdle should not be negative.");
        }
        this.minIdle = minIdle;
    }

    @Override
    public String toString() {
        return "ResourcePoolConfig_v1{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }

    /*测试*/
    static class MainApp {
        public static void main(String[] args) {
            ResourcePoolConfig_v1 config = new ResourcePoolConfig_v1("dbconnectionpool");
            config.setMaxTotal(16);
            config.setMaxIdle(8);
            System.out.println(config);
        }
    }
}




/*
    1、name是必填的，所以我们把它放到构造函数中，强制创建对象的时候就设置。如果必填的选项很多，把这些必填配置都放到构造函数中设置，
    那么构造函数就会出现参数列表很长的问题。如果我们把必填项也通过set()方法设置，那校验这些必填项是否已经填写的逻辑就无处安放了。

    2、除此之外，假设配置项之间有一定的依赖关系，比如，如果用户设置了 maxTotal、maxIdle、minIdle 其中一个，就必须显式地设置另外两个，
    或者配置项之间有一定的约束条件，比如，maxIdle 和 minIdle 要小于等于 maxTotal。如果我们继续使用现在的设计思路，那这些配置项之间的
    依赖关系或者约束条件的逻辑就无处安放了。因为这三个属性具有强依赖关系，要么全部设置成功，要么全部设置失败，只能通过一次性设置三个属性来实现。

    3、如果我们希望 ResourcePoolConfig 类对象是不可变对象。对象在创建好之后，就不能再修改内部的属性值。要实现这个功能，我们就不能在 ResourcePoolConfig
    类中暴露 set() 方法

    ============================================================
    为了解决这些问题：就需要使用到建造者模式了
    1、我们可以校验逻辑放到Builder类中，先创建建造者对象，并且通过 set() 方法设置建造者的变量值，然后在使用 build() 方法真正创建对象之前，
    做集中的校验，校验通过之后才会创建对象。
    2、除此之外，我们可以把 ResourcePoolConfig 的构造函数改为 private 权限，并不对外提供 set 方法。这样，我们就只能通过构造者来创建
    ResourcePoolConfig 类对象，这样创建出来的对象就是不可变对象了。
*/