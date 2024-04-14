package geek._68.demo03;



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
    public void accept(Extractor extractor) {
        extractor.extract2txt(this); //extractor通过依赖注入的方式获得PdfFile实例
    }

    @Override
    public void accept(Compressor compressor) {
        compressor.compress(this); //compressor通过依赖注入的方式获得PdfFile实例
    }
}
