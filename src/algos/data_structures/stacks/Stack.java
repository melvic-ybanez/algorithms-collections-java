package algos.data_structures.stacks;

import algos.utils.Pair;

/**
 * Created by ybamelcash on 3/6/2015.
 */
public class Stack<E> {
    private E head;
    private Stack<E> tail;
    private int size;
    
    public Stack(E head, Stack<E> tail) {
        this.head = head;
        this.size = 1;
        setTail(tail);
    }
    
    public Stack(E head) {
        this(head, null);
    } 
    
    public Stack() {
        this.size = 0;
    }
    
    public Stack<E> push(E head) {
        if (isEmpty()) return new Stack<>(head);
        return new Stack<>(head, this);
    }
    
    public Pair<E, Stack<E>> pop() {
       // if (isEmpty()) return new Pair<>
        return new Pair<>(head, getTail());
    }
    
    public Stack<E> getTail() {
        return tail;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return getSize() == 0;
    }
    
    public void setTail(Stack<E> tail) {
        this.tail = tail;
    }
}
