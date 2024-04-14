package geek._70.demo01;

import java.util.Stack;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 15:13
 */
public class SnapshotHolder {

    private Stack<InputText> snapshots = new Stack<>();

    public InputText popSnapshot() {
        return snapshots.pop(); // 返回被移出栈的元素
    }

    public void pushSnapshot(InputText inputText) {
        InputText deepClonedInputText = new InputText(); // 深拷贝
        deepClonedInputText.setText(inputText.getText());
        snapshots.push(deepClonedInputText);
    }
}
