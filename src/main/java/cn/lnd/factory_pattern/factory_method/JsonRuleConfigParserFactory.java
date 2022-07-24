package cn.lnd.factory_pattern.factory_method;

import cn.lnd.factory_pattern.simple_factory.IRuleConfigParser;
import cn.lnd.factory_pattern.simple_factory.JsonRuleConfigparser;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 12:13
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory{
    private static final JsonRuleConfigparser jsonRuleConfigparser = new JsonRuleConfigparser();

    @Override
    public IRuleConfigParser createParser() {
        return jsonRuleConfigparser;
    }
}
