package geek._26.demo01;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/2 21:07
 */
public class MetricsCollector {

    private MetricsStorage metricsStorage;// 基于接口而非实现编程

    public MetricsCollector() {

    }

    // 依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    // 用一个函数代替了最小原型中的两个函数
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
