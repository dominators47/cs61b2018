public class ArrayDeque<T> {

    /**
     * invariants:
     * The index of the nextFirst is always first - 1.
     * The index of the nextLast is always last + 1.
     * The number of items in the ArrayDeque is always size.
     */

    private T[] items;
    private int size;
    private double usageRatio;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int i) {

        return items[(plusOne(nextFirst) + i)%items.length];
    }

    private int minusOne(int index) {
        int j = index - 1;
        if (j == -1) {
            return items.length + j;
        } else {
            return j;
        }
    }

    private int plusOne(int index) {
        int i = index + 1;
        if (i == items.length) {
            return 0;
        } else {
            return i;
        }
    }

    private void Resize(int n) {
        T[] a = (T []) new Object[n];
        int first = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            a[i] = items[(first + i) % items.length];
        }
        items = a;
        nextFirst = n - 1;
        nextLast = size;
    }

    private T getLast() {
        return items[minusOne(nextLast)];
    }

    private T getFirst() {
        return items[plusOne(nextFirst)];
    }

    public void addLast(T x) {
        if (size == items.length) {
            Resize(size * 2);
        }
        items[nextLast] = x;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            Resize(size * 2);
        }
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }


    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T item = getLast();
            nextLast = minusOne(nextLast);
            size -= 1;
            usageRatio = (double) size / (double) items.length;
            if (items.length >= 16 && usageRatio < 0.25) {
                Resize(items.length / 2);
            }
            return item;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T item = getFirst();
            nextFirst = plusOne(nextFirst);
            size -= 1;
            usageRatio = (double) size / (double) items.length;
            if (items.length >= 16 && usageRatio < 0.25) {
                Resize(size / 2);
            }
            return item;
        }
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            T item = get(i);
            System.out.print(item);
            System.out.print(" ");
        }
    }

}