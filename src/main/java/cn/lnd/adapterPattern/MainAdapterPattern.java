package cn.lnd.adapterPattern;

/**
 * @Author lnd
 * @Description
 *  原理
 * @Date 2022/7/21 18:51
 */
public class MainAdapterPattern {

    public static void main(String[] args) {
        ChineseAdapter chineseAdapter = new ChineseAdapter(new EnglishContent("Hello"));
        String res = chineseAdapter.translate();
        System.out.println(res);    // 你好
    }
}
