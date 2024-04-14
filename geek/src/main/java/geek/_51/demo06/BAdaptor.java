package geek._51.demo06;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 16:29
 */
public class BAdaptor implements IA {

    private B b;

    public BAdaptor(B b) {
        this.b = b;
    }

    @Override
    public void fa() {
        b.fb();
    }
}
