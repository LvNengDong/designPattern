package geek._10.demo03;

import geek._10.demo02.EggLayable;
import geek._10.demo02.Tweetable;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/26 22:12
 */
public class Ostrich implements Tweetable, EggLayable {

    private TweetAbility tweetAbility = new TweetAbility(); //组合
    private EggLayAbility eggLayAbility = new EggLayAbility(); //组合

    @Override
    public void layEgg() {
        // 委托
        tweetAbility.tweet();
    }

    @Override
    public void tweet() {
        //委托
        eggLayAbility.layEgg();
    }
}
