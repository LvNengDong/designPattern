package geek._92.demo01.alg;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 23:49
 */
public class RateLimitAlg {
    public RateLimitAlg(Integer limit) {
        this.limit = limit;
    }

    private Integer limit;
    public boolean tryAcquire() {
        return false;
    }
}
