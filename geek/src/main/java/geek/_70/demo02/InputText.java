package geek._70.demo02;

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

    // 追加写
    public void append(String input) {
        text.append(input);
    }

    public SnapShot createSnapshot() {
        return new SnapShot(text.toString());
    }

    public void restoreSnapshot(String text) {
        this.text.replace(0, this.text.length(), text);
    }
}
