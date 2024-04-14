package geek._22.demo02;

import geek._22.demo01.Html;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/2 11:31
 */
public class DocumentFactory {

    private HtmlDownloader downloader;

    public DocumentFactory(HtmlDownloader downloader) {
        this.downloader = downloader;
    }

    public Document createDocument(String url) {
        Html html = downloader.downloadHtml(url);
        return new Document(url, html);
    }
}
