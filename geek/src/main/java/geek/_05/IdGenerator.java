package geek._05;

import lombok.Getter;

import java.util.stream.DoubleStream;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/26 12:19
 */
public class IdGenerator {

    @Getter
    private static IdGenerator instance = new IdGenerator();

    public String generate() {
        return "xxx";
    }
}
