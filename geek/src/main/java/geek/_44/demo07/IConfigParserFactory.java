package geek._44.demo07;

import geek._44.demo01.IRuleConfigParser;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 21:49
 */
public interface IConfigParserFactory {
    IRuleConfigParser createRuleParser();

    ISystemConfigParser createSystemParser();

    //此处可以扩展新的parser类型，比如IBizConfigParser
}
