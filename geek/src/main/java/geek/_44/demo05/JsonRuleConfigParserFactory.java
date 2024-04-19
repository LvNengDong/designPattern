package geek._44.demo05;

import geek._44.demo01.IRuleConfigParser;
import geek._44.demo01.JsonRuleConfigParser;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 21:29
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
