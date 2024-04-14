package geek._62.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/7 23:21
 */
public class Application {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerB());
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());

        chain.handle();
    }
}
