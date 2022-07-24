package cn.lnd.methodology.solid.dip.ioc.second;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/24 22:41
 */
public class JunitApplication {

    private static final List<TestCase> testCases = Lists.newArrayList();

    public static void register(TestCase testCase){
        testCases.add(testCase);
    }

    public static void main(String[] args) {
        for (TestCase aCase : testCases) {
            aCase.run();
        }
    }
}
