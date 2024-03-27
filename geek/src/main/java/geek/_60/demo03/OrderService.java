package geek._60.demo03;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/27 21:54
 */
public class OrderService {
    public double discount(Order order) {
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(order);
        return discountStrategy.calDiscount(order);
    }

}
