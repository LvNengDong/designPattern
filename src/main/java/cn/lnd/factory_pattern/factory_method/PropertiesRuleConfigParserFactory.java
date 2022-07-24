package cn.lnd.factory_pattern.factory_method;

import cn.lnd.factory_pattern.simple_factory.IRuleConfigParser;
import cn.lnd.factory_pattern.simple_factory.PropertiesRuleConfigparser;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 12:13
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory{
    private static final PropertiesRuleConfigparser propertiesRuleConfigparser = new PropertiesRuleConfigparser();

    @Override
    public IRuleConfigParser createParser() {
        return propertiesRuleConfigparser;
    }
}
