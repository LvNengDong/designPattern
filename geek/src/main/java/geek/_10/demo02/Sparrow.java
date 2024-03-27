package geek._10.demo02;

/**
 * @Author lnd
 * @Description 麻雀
 * @Date 2024/3/26 21:57
 */
public class Sparrow implements Flyable, EggLayable, Tweetable{
    @Override
    public void layEgg() {
        System.out.println("下单麻雀");
    }

    @Override
    public void fly() {
        System.out.println("飞天麻雀");
    }

    @Override
    public void tweet() {
        System.out.println("怒吼麻雀");
    }
}
