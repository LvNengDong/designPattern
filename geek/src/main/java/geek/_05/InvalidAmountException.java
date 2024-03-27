package geek._05;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/26 15:33
 */
public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(String msg) {
        super(msg);
    }
}
