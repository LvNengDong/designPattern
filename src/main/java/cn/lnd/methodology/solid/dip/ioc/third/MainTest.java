package cn.lnd.methodology.solid.dip.ioc.third;

import cn.lnd.methodology.solid.dip.ioc.second.JunitApplication;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:55
 */
public class MainTest {
    public static void main(String[] args) {
        // 注册操作还可以通过配置的方式来实现，不需要程序员显式调用 register
        JunitApplication.register(new UserServiceTest());
    }
}
