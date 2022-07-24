package cn.lnd.adapter_pattern;

/**
 * @Author lnd
 * @Description 中文适配器，作用是将英文翻译成中文
 * @Date 2022/7/21 18:55
 */
public class ChineseAdapter implements Adapter{

    private EnglishContent englishContent;

    public ChineseAdapter(EnglishContent englishContent) {
        this.englishContent = englishContent;
    }

    @Override
    public String translate() {
        // 得到英文内容
        String content = englishContent.getContent();
        // 翻译成中文内容
        String chineseContent = englishToChinese(content);

        return chineseContent;
    }


    private String englishToChinese(String english){
        // TODO 将英文内容翻译成中文内容
        String chineseContent = "你好";

        return chineseContent;
    }
}
