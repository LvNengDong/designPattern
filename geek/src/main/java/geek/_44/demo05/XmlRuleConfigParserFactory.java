package geek._44.demo05;

import geek._44.demo01.IRuleConfigParser;
import geek._44.demo01.XmlRuleConfigParser;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 21:29
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
