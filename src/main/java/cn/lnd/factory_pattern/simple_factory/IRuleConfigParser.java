package cn.lnd.factory_pattern.simple_factory;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 10:37
 */
public interface IRuleConfigParser {
    RuleConfig parse(String configtext);
}