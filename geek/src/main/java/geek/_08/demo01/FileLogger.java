package geek._08.demo01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/27 11:29
 */
public class FileLogger extends Logger {

    private Writer fileWriter;

    public FileLogger(String name, boolean enabled, Level minPermittedLevel, String filePath) throws IOException {
        super(name, enabled, minPermittedLevel);
        this.fileWriter = new FileWriter(filePath);
    }

    @Override
    protected void doLog(Level level, String message) {
        try {
            // 格式化level和message，输出到日志文件
            fileWriter.write("...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
