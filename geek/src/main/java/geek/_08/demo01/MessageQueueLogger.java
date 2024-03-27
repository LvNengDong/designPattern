package geek._08.demo01;

import java.util.logging.Level;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/27 11:33
 */
public class MessageQueueLogger extends Logger{

    private MessageQueueClient messageQueueClient;

    public MessageQueueLogger(String name, boolean enabled, Level minPermittedLevel, MessageQueueClient messageQueueClient) {
        super(name, enabled, minPermittedLevel);
        this.messageQueueClient = messageQueueClient;
    }

    @Override
    protected void doLog(Level level, String message) {
        // 格式化level和message，输出到消息中间件
        this.messageQueueClient.send("...");
    }
}
