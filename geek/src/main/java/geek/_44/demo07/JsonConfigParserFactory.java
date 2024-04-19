package geek._44.demo07;

import geek._44.demo01.IRuleConfigParser;
import geek._44.demo01.JsonRuleConfigParser;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 21:51
 */
public class JsonConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}
