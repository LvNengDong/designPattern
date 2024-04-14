package geek._69.demo02;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 14:42
 */
public abstract class ResourceFile {
    private String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract ResourceFileType getType();
}
