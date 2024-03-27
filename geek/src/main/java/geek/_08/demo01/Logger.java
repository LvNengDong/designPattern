package geek._08.demo01;

import java.util.logging.Level;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/27 11:26
 */
public abstract class Logger {
    private String name;
    private boolean enabled;
    private Level minPermittedLevel; // 日志的最小级别

    public Logger(String name, boolean enabled, Level minPermittedLevel) {
        this.name = name;
        this.enabled = enabled;
        this.minPermittedLevel = minPermittedLevel;
    }

    public void log(Level level, String message) {
        boolean loggable = enabled && (minPermittedLevel.intValue() <= level.intValue());
        if (!loggable) return;
        doLog(level, message);
    }


    protected abstract void doLog(Level level, String message);
}
