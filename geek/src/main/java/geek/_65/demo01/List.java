package geek._65.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/8 23:48
 */
public interface List<E> {
    Iterator iterator();

    void add(E element);
}
