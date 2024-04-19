package geek._44.demo06;

import geek._44.demo01.IRuleConfigParser;
import geek._44.demo01.InvalidRuleConfigException;
import geek._44.demo01.RuleConfig;
import geek._44.demo05.*;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/27 19:00
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) throws InvalidRuleConfigException {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfgParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        String configText = "";
        IRuleConfigParser parser = parserFactory.createParser();
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}

