package geek._65.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/8 23:38
 */
public interface Iterator<E> {

    /**
     * 是否存在下一位元素
     * @return
     */
    boolean hasNext();

    /**
     * 将游标后移一位元素
     */
    void next();

    /**
     * 返回当前元素
     * @return
     */
    E currentItem();
}
