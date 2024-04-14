package geek._68.demo04;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 13:12
 */
public class ToolApplication {
    public static void main(String[] args) {
        // 读文件，按后缀分发给不同的处理器
        String resourceDirectory = "todo...";
        List<ResourceFile> resourceFiles = listAllResourceFiles(resourceDirectory);

        Extractor extractor = new Extractor();
        Compressor compressor = new Compressor();
        // 执行抽取txt逻辑
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }

        System.out.println("-------------");

        // 执行压缩逻辑
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String resourceDirectory) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }
}
