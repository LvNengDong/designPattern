package geek._16.demo02;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/23 00:02
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.getInstance();
        Alert_V2 alert = context.getAlert();
        alert.check(new ApiStatInfo());
    }
}
