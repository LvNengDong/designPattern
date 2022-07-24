package cn.lnd.factory_pattern.factory_method;

import cn.lnd.factory_pattern.simple_factory.IRuleConfigParser;
import cn.lnd.factory_pattern.simple_factory.XmlRuleConfigparser;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 12:13
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory{
    private static final XmlRuleConfigparser xmlRuleConfigparser = new XmlRuleConfigparser();

    @Override
    public IRuleConfigParser createParser() {
        return xmlRuleConfigparser;
    }
}
