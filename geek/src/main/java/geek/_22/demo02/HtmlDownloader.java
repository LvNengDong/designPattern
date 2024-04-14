package geek._22.demo02;

import geek._22.demo01.Html;
import geek._22.demo01.HtmlRequest;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/2 11:25
 */
public class HtmlDownloader {
    private NetworkTransporter transporter;// 通过构造函数或 IOC 注入

    // HtmlDownloader 这里也要有相应的修改
    public Html downloadHtml(String url) {
        HtmlRequest htmlRequest = new HtmlRequest(url);
        Byte[] rawHtml = transporter.send(
                htmlRequest.getAddress(), htmlRequest.getContent().getBytes());
        return new Html(rawHtml);
    }
}
