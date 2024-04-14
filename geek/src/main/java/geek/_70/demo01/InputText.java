package geek._70.demo01;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 15:12
 */
public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    // 覆盖写
    public void setText(String text) {
        this.text.replace(0, this.text.length(), text);
    }

    // 追加写
    public void append(String input) {
        text.append(input);
    }
}
