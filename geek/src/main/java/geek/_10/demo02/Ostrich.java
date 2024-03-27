package geek._10.demo02;

/**
 * @Author lnd
 * @Description 鸵鸟
 * @Date 2024/3/26 21:56
 */
public class Ostrich implements Flyable, EggLayable{
    @Override
    public void layEgg() {
        System.out.println("下单鸵鸟");
    }

    @Override
    public void fly() {
        System.out.println("飞天鸵鸟");
    }
}
