package geek._26.demo01;

import java.util.List;
import java.util.Map;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/2 21:07
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
