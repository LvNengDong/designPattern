package geek._69.demo02;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 14:44
 */
public class PPTFile extends ResourceFile{
    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PPT;
    }
}
