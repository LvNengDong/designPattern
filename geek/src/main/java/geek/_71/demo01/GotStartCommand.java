package geek._71.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 20:21
 */
public class GotStartCommand implements Command{
    private String data;

    public GotStartCommand(String data) {
        this.data = data;
    }

    @Override
    public void excute() {
        // 执行相应的逻辑
    }
}
