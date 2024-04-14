package geek._41.demo01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/3 16:42
 */
public class Logger {

    private FileWriter writer;

    public Logger() {
        try {
            File file = new File("/Users/wangzheng/log.txt");
            writer = new FileWriter(file, true); //true表示追加写入
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
