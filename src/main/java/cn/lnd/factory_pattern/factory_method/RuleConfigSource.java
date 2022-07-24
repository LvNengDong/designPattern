package cn.lnd.factory_pattern.factory_method;


import cn.lnd.factory_pattern.simple_factory.IRuleConfigParser;
import cn.lnd.factory_pattern.simple_factory.InvalidRuleConfigException;
import cn.lnd.factory_pattern.simple_factory.RuleConfig;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 12:31
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {

        // 获取文件名后缀
        String ruleConfigExtension = getFileExtension(ruleConfigFilePath);

        // 根据文件名后缀，创建不同的解析器
        IRuleConfigParserFactory factory = null;
        if ("json".equalsIgnoreCase(ruleConfigExtension)) {
            factory = new JsonRuleConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(ruleConfigExtension)) {
            factory = new XmlRuleConfigParserFactory();
        } else if ("yaml".equalsIgnoreCase(ruleConfigExtension)) {
            factory = new YamlRuleConfigParserFactory();
        } else if ("properties".equalsIgnoreCase(ruleConfigExtension)) {
            factory = new PropertiesRuleConfigParserFactory();
        } else {
            throw new InvalidRuleConfigException("Rule config file format is not supported：" + ruleConfigFilePath);
        }

        IRuleConfigParser parser = factory.createParser();

        String configText = "This is a config info context"; // 模拟从文件中读到的数据
        // 使用解析器，将存储在文件中的配置解析成内存对象RuleConfig
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }


    /**
     * 解析文件名获取扩展名
     * For Example：rule.josn -> json
     *
     * @param ruleConfigFilePath 文件名名
     * @return 文件名后缀
     */
    private String getFileExtension(String ruleConfigFilePath) {
        // TODO
        return "json";
    }
}
