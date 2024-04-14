package geek._70.demo02;


import java.util.Stack;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 15:13
 */
public class SnapshotHolder {

    private Stack<SnapShot> snapshots = new Stack<>();

    public SnapShot popSnapshot() {
        return snapshots.pop(); // 返回被移出栈的元素
    }

    public void pushSnapshot(SnapShot snapShot) {
        snapshots.push(snapShot);
    }
}
