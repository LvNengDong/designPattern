package geek._68.demo04;


/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 12:07
 */
public class Extractor implements Visitor {
    @Override
    public void visit(PPTFile pptFile) {
        //...
        System.out.println("Extract PPT.");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Extract PDF.");
    }

    @Override
    public void visit(WordFile wordFile) {
        //...
        System.out.println("Extract WORD.");
    }

}
