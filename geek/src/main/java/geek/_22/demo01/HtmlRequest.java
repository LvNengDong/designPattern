package geek._22.demo01;
import lombok.Data;


/**
 * @Author lnd
 * @Description
 * @Date 2024/4/2 11:15
 */
@Data
public class HtmlRequest {
    private String url;
    private String address;
    private String content;

    public HtmlRequest(String url) {
        this.url = url;
    }
}
