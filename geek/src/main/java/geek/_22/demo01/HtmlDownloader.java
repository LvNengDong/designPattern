package geek._22.demo01;

/**
 * @Author lnd
 * @Description
 *      通过 URL 获取网页
 * @Date 2024/4/2 11:16
 */
public class HtmlDownloader {
    private NetworkTransporter transporter;// 通过构造函数或 IOC 注入

    public Html downloadHtml(String url) {
        Byte[] rawHtml = transporter.send(new HtmlRequest(url));
        return new Html(rawHtml);
    }
}
