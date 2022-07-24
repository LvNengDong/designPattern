package cn.lnd.factory_pattern.factory_method;

import cn.lnd.factory_pattern.simple_factory.IRuleConfigParser;
import cn.lnd.factory_pattern.simple_factory.YamlRuleConfigparser;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 12:13
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory{
    private static final YamlRuleConfigparser yamlRuleConfigparser = new YamlRuleConfigparser();

    @Override
    public IRuleConfigParser createParser() {
        return yamlRuleConfigparser;
    }
}
