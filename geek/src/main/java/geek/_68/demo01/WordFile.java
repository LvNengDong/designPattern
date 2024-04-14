package geek._68.demo01;

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
    public void extract2Txt() {
        //...
        System.out.println("Extract WORD.");
    }
}
