public class ListPQueue<E> {
    private ArrayList<E> elts;

    public ListPQueue()      { elts = new ArrayList<E>(); }
    public boolean isEmpty() { return elts.size() == 0;   }
    public void add(E value) { elts.add(value);           }

    public E peek() {
        E min = elts.get(0); // minimum seen so far
        for(int i = 1; i < elts.size(); i++) {
            Comparable<E> val = (Comparable<E>) elts.get(i);
            if(val.compareTo(min) < 0) min = (E) val;
        }
        return min;
    }

    public E remove() {
        E min = elts.get(0); // minimum seen so far
        int minPos = 0;           // position of min within elts
        for(int i = 1; i < elts.size(); i++) {
            Comparable<E> val = (Comparable<E>) elts.get(i);
            if(val.compareTo(min) < 0) { min = (E) val; minPos = i; }
        }
        elts.remove(minPos);
        return min;
    }
}