package geek._68.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 11:47
 */
public abstract class ResourceFile {

    private String filePath;

    protected ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract void extract2Txt();

}
