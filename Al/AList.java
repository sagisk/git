public class AList<Item> implements List61B<Item> {

    private Item[] array;
    private int _size;

    public AList() {
        array = (Item[]) new Object[100];
        _size = 0;
    }

    @Override
    public void insert(Item x, int position) {
        array[position] = x;
    }

    private void resize (int capacity,String message) {
        Item[] tmp = (Item[]) new Object[this._size * 2];
        if (message.equals("AddLast")) {
            System.arraycopy(array, 0, tmp, 0, this._size);
        } else {
            System.arraycopy(array, 0, tmp, 1, this._size);
        }
        array = tmp;
    }

    @Override
    public void addLast(Item x) {
        if (this._size == array.length) {
            resize(this._size + 1,"AddLast");
        }
        array[this._size] = x;
        _size += 1;
    }

    @Override
    public void addFirst(Item x) {
        if (this._size == array.length) {
            resize(this._size + 1,"AddFirst");
        }
        array[0] = x;
        _size += 1;
    }

    @Override
    public Item getLast() {
        return array[this._size- 1];
    }

    @Override
    public Item getFirst() {
        return array[0];
    }

    @Override
    public Item get(int i) {
        return array[i];
    }

    @Override
    public int size() {
        return this._size;
    }

    @Override
    public Item removeLast() {
        Item x = getLast();
        this._size -= 1;
        return x;
    }

    public void reverse() {
        for (int i = 0; i < array.length; i++){
            int j = array.length - i - 1;
            Item tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
