package cn.lnd.factory_pattern.factory_method;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 12:20
 */
public class MainApp {
    public static void main(String[] args) {
        IRuleConfigParserFactory factory = new JsonRuleConfigParserFactory();
        // 多态
        factory.createParser();
    }
}
