package geek._05;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/26 16:01
 */
public class InsufficientAmountException extends RuntimeException{
    public InsufficientAmountException(String msg) {
        super(msg);
    }
}
