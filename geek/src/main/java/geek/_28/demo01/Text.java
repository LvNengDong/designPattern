package geek._28.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/3 14:40
 */
public class Text {
    private String content;

    public Text(String content) {
        this.content = content;
    }

    /**
     * 将字符串转化成数字，忽略字符串中的首尾空格；
     * 如果字符串中包含除首尾空格之外的非数字字符，则返回 null。
     */
    public Integer toNumber() {
        if (content == null || content.isEmpty()) {
            return null;
        }
        //... 省略代码实现...
        return null;
    }
}
