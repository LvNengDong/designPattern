package geek._68.demo03;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 12:25
 */
public abstract class ResourceFile {
    private String fileName;

    public ResourceFile(String fileName) {
        this.fileName = fileName;
    }

    // 通过依赖注入的方式获得Extractor实例
    public abstract void accept(Extractor extractor);

    // 通过依赖注入的方式获得Compressor实例
    public abstract void accept(Compressor compressor);

}
