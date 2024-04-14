package geek._65.demo01;

import java.util.NoSuchElementException;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/8 23:40
 */
public class ArrayIterator<E> implements Iterator<E> {

    private int cursor; //游标
    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }


    @Override
    public boolean hasNext() {
        return cursor != arrayList.size(); //注意这里，cursor在指向最后一个元素的时候，hasNext()仍旧返回true。
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if (cursor >= arrayList.size()) {
            throw new NoSuchElementException();
        }
        return arrayList.get(cursor);
    }
}
