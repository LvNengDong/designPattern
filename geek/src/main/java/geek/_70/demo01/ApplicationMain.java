package geek._70.demo01;

import java.util.Scanner;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 15:12
 */
public class ApplicationMain {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.getText());
            } else if (input.equals(":undo")) {
                InputText snapshot = snapshotHolder.popSnapshot();
                System.out.println("xxx: " + snapshot.getText());
                inputText.setText(snapshot.getText());
            } else {
                // 注意：下面这两行的顺序不能换，快照版本需要慢正式版本一步！！！
                snapshotHolder.pushSnapshot(inputText);
                inputText.append(input);
            }
        }
    }
}
