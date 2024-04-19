package geek._44.demo05;

import geek._44.demo01.IRuleConfigParser;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 21:29
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
