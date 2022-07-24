package cn.lnd.factory_pattern.simple_factory;

/**
 * @Author lnd
 * @Description 工厂类
 * @Date 2022/7/23 11:30
 */
public class RuleConfigParseFactory {

    /**
     * 根据文件名后缀，创建不同的解析器
     *
     * @param configFormat 文件名后缀
     * @return
     */
    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigparser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigparser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigparser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigparser();
        }
        return parser;
    }
}
