package geek._22.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/2 11:18
 */
public class Document {
    private Html html;
    private String url;

    public Document(String url) {
        this.url = url;
        HtmlDownloader downloader = new HtmlDownloader();
        this.html = downloader.downloadHtml(url);
    }
    //...
}
