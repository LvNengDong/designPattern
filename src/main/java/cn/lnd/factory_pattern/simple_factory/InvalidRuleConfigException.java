package cn.lnd.factory_pattern.simple_factory;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 10:43
 */
public class InvalidRuleConfigException extends RuntimeException {

    public InvalidRuleConfigException(String s) {
        super(s);
    }
}
