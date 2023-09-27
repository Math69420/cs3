public class PriorityQueue<E> {
    private E[] data;
    private int size;

    public PriorityQueue(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        return data[0];
    }

    public void add(E value) {
        int pos = size;             // virtual position of value
        int pPos = (pos - 1) / 2;   // position of parent
        size++;
        Comparable<E> compValue = (Comparable<E>) value;
        while(pos > 0 && compValue.compareTo(data[pPos]) < 0) {
            data[pos] = data[pPos]; // move parent into position
            pos = pPos;             // and step upward
            pPos = (pos - 1) / 2;
        }
        data[pos] = value;          // place value in final position
    }

    public E remove() {
        E ret = data[0];
        size--;                   // move last item to root,
        Comparable<E> toTrickle = (Comparable<E>) data[size]; // trickle it down
        data[size] = null;
        int pos = 0;
        while(true) {
            int less = 2 * pos + 1; // determine lesser of children
            if(less >= size) break;
            Comparable<E> left = (Comparable<E>) data[less];
            if(less + 1 < size && left.compareTo(data[less + 1]) > 0) {
                less++;
            }

            if(toTrickle.compareTo(data[less]) < 0) break;
            data[pos] = data[less];
            pos = less;
        }
        data[pos] = (E) toTrickle;

        return ret;
    }
}