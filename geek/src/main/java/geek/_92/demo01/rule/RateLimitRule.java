package geek._92.demo01.rule;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 23:51
 */
public class RateLimitRule {
    private RuleConfig ruleConfig;

    public RateLimitRule(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    public ApiLimit getLimit(String appId, String url) {
        return null;
    }
}
