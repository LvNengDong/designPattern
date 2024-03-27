package geek._16.demo02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/22 23:36
 */
public class Alert_V2 {

    private final List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        alertHandlers.forEach(alertHandler -> alertHandler.check(apiStatInfo));
    }
}
