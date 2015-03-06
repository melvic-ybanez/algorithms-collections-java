package algos.data_structures.list;

import algos.utils.Pair;

/**
 * Created by ybamelcash on 3/6/2015.
 */
public class List<T> {
    private T item;
    private List<T> next;
    private int size = 1;
    
    public List(T item, List<T> next) {
        this.item = item;
        setNext(next);
    }
    
    public List(T item) {
        this(item, null);
    }
    
    public List<T> search(T item) {
        if (this.item.equals(item)) {
            return this;    
        }
        if (!hasNext()) return null;
        return getNext().search(item);
    }
    
    public List<T> insert(T item) {
        return new List<>(item, this);
    }
    
    public List<T> predecessor(T item) {
        if (!hasNext()) return null;
        if (getNext().getItem().equals(item)) return this;
        return getNext().predecessor(item);
    }
    
    public Pair<Boolean, List<T>> delete(T item) {
        List<T> node = search(item);
        if (node == null) return new Pair<>(false, this);
        List<T> pred = predecessor(item);
        Pair<Boolean, List<T>> result = new Pair<>(true, this);
        
        if (pred == null) {
            result = result.withSecond(getNext());
        } else {
            pred.setNext(node.getNext());
        }
        
        return result;
    }
    
    public void setNext(List<T> next) {
        this.next = next;
        if (next != null) {
            size += getNext().getSize();
        }
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
        return size;
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
        String itemString = getItem().toString();
        if (hasNext()) 
            return itemString + " " + getNext();
        return itemString;
    }
}
