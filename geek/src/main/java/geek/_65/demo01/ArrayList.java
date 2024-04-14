package geek._65.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/8 23:49
 */
public class ArrayList<E> implements List<E> {
    private Object[] elements;
    private int size;
    private int length = 1024;

    public ArrayList() {
        this.elements = new Object[length];
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator(this);
    }

    @Override
    public void add(E element) {
        elements[size] =  element;
        size++;
    }

    public int size() {
        return size;
    }

    public E get(int cursor) {
        Object element = elements[cursor];
        return (E)element;
    }
}
