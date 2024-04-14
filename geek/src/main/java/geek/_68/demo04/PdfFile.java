package geek._68.demo04;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 11:50
 */
public class PdfFile extends ResourceFile {
    public PdfFile(String filePath) {
        super(filePath);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); //Visitor通过依赖注入的方式获得PdfFile实例
    }

}
