package cn.lnd.factory_pattern.simple_factory;

/**
 * @Author lnd
 * @Description 简单工厂模式Case
 * @Date 2022/7/23 10:32
 */
public class RuleConfigSourceV3 {

    public RuleConfig load(String ruleConfigFilePath) {

        // 获取文件名后缀
        String ruleConfigExtension = getFileExtension(ruleConfigFilePath);

        // 根据文件名后缀，创建不同的解析器
        IRuleConfigParser parser = RuleConfigParseFactory.createParser(ruleConfigExtension);
        if (parser == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported：" + ruleConfigFilePath);
        }

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
