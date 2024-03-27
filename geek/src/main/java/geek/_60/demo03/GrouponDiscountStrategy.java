package geek._60.demo03;

/**
 * @Author lnd
 * @Description 团购订单
 * @Date 2024/3/27 21:47
 */
public class GrouponDiscountStrategy implements DiscountStrategy{
    @Override
    public double calDiscount(Order order) {
        return 0;
    }
}
