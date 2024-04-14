package geek._51.demo05;

/**
 * @Author lnd
 * @Description 使用适配器模式进行改造-
 * @Date 2024/4/14 16:14
 */
public interface ISensitiveWordsFilter { // 统一接口定义
    String filter(String text);
}
