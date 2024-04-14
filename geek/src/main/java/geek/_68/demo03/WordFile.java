package geek._68.demo03;



/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 11:50
 */
public class WordFile extends ResourceFile {
    public WordFile(String filePath) {
        super(filePath);
    }
    @Override
    public void accept(Extractor extractor) {
        extractor.extract2txt(this);
    }
    @Override
    public void accept(Compressor compressor) {
        compressor.compress(this);
    }
}
