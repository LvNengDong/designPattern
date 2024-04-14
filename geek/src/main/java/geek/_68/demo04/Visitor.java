package geek._68.demo04;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 12:49
 */
public interface Visitor {
    void visit(PdfFile pdfFile);
    void visit(PPTFile pdfFile);
    void visit(WordFile pdfFile);
}
