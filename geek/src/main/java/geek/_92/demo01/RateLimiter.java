package geek._92.demo01;

import geek._92.demo01.alg.RateLimitAlg;
import geek._92.demo01.rule.ApiLimit;
import geek._92.demo01.rule.RateLimitRule;
import geek._92.demo01.rule.RuleConfig;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 23:48
 */
@Slf4j
public class RateLimiter {
    // 为每个API在内存中存储限流器
    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public RateLimiter() {
        // 将限流规则配置文件 ratelimiter-rule.yaml 中的内容读到 RuleConfig 中
        InputStream in = null;
        RuleConfig ruleConfig = null;
        try {
            in = this.getClass().getResourceAsStream("/ratelimiter-rule.yaml");
            if (in != null) {
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, RuleConfig.class);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("close file error", e);
                }
            }
        }
        // 将限流规则构建成支持快速查找的数据结构 RateLimitRule
        this.rule = new RateLimitRule(ruleConfig);
    }

    public boolean limit(String appId, String url) {
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit ==null) {
            return true; // 不限流
        }
        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            RateLimitAlg newRateLimitAlg = new RateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitAlg);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitAlg;
            }
        }
        // 判断是否限流
        return rateLimitCounter.tryAcquire();
    }
}
