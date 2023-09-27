public class TreePQueue<E> {
    private TreeSet<E> elts;

    public TreePQueue()      { elts = new TreeSet<E>();       }
    public boolean isEmpty() { return elts.size() == 0;       }
    public E peek()          { return elts.iterator().next(); }
    public void add(E value) { elts.add(value);               }

    public E remove() {
        Iterator<E> it = elts.iterator();
        E ret = it.next();
        it.remove();
        return ret;
    }
}