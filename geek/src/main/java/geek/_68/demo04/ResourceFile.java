package geek._68.demo04;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 12:49
 */
public abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    abstract public void accept(Visitor vistor);
}
