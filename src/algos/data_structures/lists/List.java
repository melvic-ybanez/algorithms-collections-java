package algos.data_structures.lists;

/**
 * Created by ybamelcash on 3/6/2015.
 */
public class List<T> {
    private T item;
    private List<T> next;
    
    public List(T item, List<T> next) {
        reset(item, next);
    }
    
    public List(T item) {
        this(item, null);
    }
    
    public List() {}
    
    public List<T> search(T item) {
        if (isEmpty()) return null;
        if (this.item.equals(item)) {
            return this;    
        }
        if (!hasNext()) return null;
        return getNext().search(item);
    }
    
    public List<T> insert(T item) {
        if (isEmpty()) {
            reset(item, null);
        } else {
            reset(item, new List<>(getItem(), getNext()));
        }
        return this;
    }
    
    public List<T> predecessor(T item) {
        if (!hasNext()) return null;
        if (getNext().getItem().equals(item)) return this;
        return getNext().predecessor(item);
    }
    
    public boolean delete(T item) {
        List<T> node = search(item);
        if (node == null) return false;
        
        List<T> pred = predecessor(item);
        if (pred == null) {  // delete head
            if (hasNext()) {
                reset(getNext().getItem(), getNext().getNext());
            } else {
                clear();
            }
        } else {
            pred.setNext(node.getNext());
        }
        
        return true;
    }
    
    public void setNext(List<T> next) {
        this.next = next;
    }
    
    private void setItem(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
    
    public List<T> getNext() {
        return next;
    }
    
    public boolean hasNext() {
        return getNext() != null;
    }
    
    public int getSize() {
        if (isEmpty()) return 0;
        if (!hasNext()) return 1;
        return 1 + getNext().getSize();
    }
    
    public boolean isEmpty() {
        return getItem() == null && !hasNext();
    }
    
    public void clear() {
        reset(null, null);
    }
    
    private void reset(T item, List<T> next) {
        setItem(item);
        setNext(next);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        List<T> that = (List<T>) obj;
        boolean itemsEqual =  this.getItem().equals(that.getItem());
        if (hasNext()) {
            boolean equalNexts = getNext().equals(that.getNext());
            return itemsEqual && equalNexts;
        } 
        return itemsEqual && !that.hasNext(); 
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return " ";
        String itemString = getItem().toString();
        if (hasNext()) 
            return itemString + " " + getNext();
        return itemString;
    }
}
