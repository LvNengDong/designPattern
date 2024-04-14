package geek._92.demo01.rule;

import lombok.Data;

import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 23:53
 */
@Data
public class RuleConfig {

    private List<AppRuleConfig> configs;

    @Data
    public static class AppRuleConfig {
        private String appId;
        private List<ApiLimit> limits;

        public AppRuleConfig() {
        }

        public AppRuleConfig(String appId, List<ApiLimit> limits) {
            this.appId = appId;
            this.limits = limits;
        }
    }
}
