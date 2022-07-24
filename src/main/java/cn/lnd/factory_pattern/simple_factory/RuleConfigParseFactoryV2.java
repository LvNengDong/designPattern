package cn.lnd.factory_pattern.simple_factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lnd
 * @Description 简单工厂模式+单例模式
 * @Date 2022/7/23 11:30
 */
public class RuleConfigParseFactoryV2 {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigparser());
        cachedParsers.put("xml", new XmlRuleConfigparser());
        cachedParsers.put("yaml", new YamlRuleConfigparser());
        cachedParsers.put("properties", new PropertiesRuleConfigparser());
    }

    /**
     * 根据文件名后缀，创建不同的解析器
     *
     * @param configFormat 文件名后缀
     * @return
     */
    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()){
            throw new IllegalArgumentException();
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}
