package geek._22.demo02;

import geek._22.demo01.Html;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/2 11:31
 */
public class Document {
    private Html html;
    private String url;

    public Document(String url, Html html) {
        this.html = html;
        this.url = url;
    }
}
