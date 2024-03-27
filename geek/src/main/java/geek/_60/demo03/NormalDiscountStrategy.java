package geek._60.demo03;

/**
 * @Author lnd
 * @Description 普通订单
 * @Date 2024/3/27 21:47
 */
public class NormalDiscountStrategy implements DiscountStrategy{
    @Override
    public double calDiscount(Order order) {
        return 0;
    }
}
