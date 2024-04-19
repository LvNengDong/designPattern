package geek._44.demo07;

import geek._44.demo01.IRuleConfigParser;
import geek._44.demo01.XmlRuleConfigParser;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 21:52
 */
public class XmlConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new XmlRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new XmlSystemConfigParser();
    }
}
