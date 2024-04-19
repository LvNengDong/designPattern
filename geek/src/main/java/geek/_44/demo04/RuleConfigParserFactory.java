package geek._44.demo04;

import geek._44.demo01.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lnd
 * @Description 简单工厂实现方式二
 * @Date 2024/4/14 21:22
 */
public class RuleConfigParserFactory {
    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;//返回null还是IllegalArgumentException全凭你自己说了算
        }
        return cachedParsers.get(configFormat.toLowerCase());
    }
}
