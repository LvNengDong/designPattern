package geek._68.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 11:49
 */
public class PPTFile extends ResourceFile {

    protected PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public void extract2Txt() {
        //...省略一大坨从PPT中抽取文本的代码...
        //...将抽取出来的文本保存在跟filePath同名的.txt文件中...
        System.out.println("Extract PPT.");
    }
}
