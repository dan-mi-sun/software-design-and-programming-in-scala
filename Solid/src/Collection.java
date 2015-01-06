import java.util.Iterator;

public interface Collection<E> extends Iterable<E> {
//-- Basic operations
    public int size();
    public boolean isEmpty();
    public boolean contains(Object o); 
    public boolean add(E o);                    // Optional
    public boolean remove(Object o);            // Optional
    public Iterator<E> iterator();
//-- Collection operations
    public boolean containsAll(Collection<?> c);
    public boolean addAll(Collection<? extends E> c); // Optional
    public boolean removeAll(Collection<?> c);  // Optional
    public boolean retainAll(Collection<?> c);  // Optional
    public void clear();                        // Optional
//-- Array operations
    public Object[] toArray();
    public <T> T[] toArray(T[] a);
}