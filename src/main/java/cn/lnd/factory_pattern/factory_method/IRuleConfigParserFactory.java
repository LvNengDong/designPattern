package cn.lnd.factory_pattern.factory_method;

import cn.lnd.factory_pattern.simple_factory.IRuleConfigParser;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 12:11
 */
public interface IRuleConfigParserFactory {
    /**
     * 创建 RuleConfigParser 实例对象
     *
     * @return
     */
    IRuleConfigParser createParser();
}
