package algos.data_structures.stacks;

import algos.utils.Pair;

/**
 * Created by ybamelcash on 3/6/2015.
 */
public class Stack<E> {
    private E head;
    private Stack<E> tail;
    
    public Stack(E head, Stack<E> tail) {
        reset(head, tail);
    }
    
    public Stack(E head) {
        this(head, null);
    } 
    
    public Stack() {}
    
    public Stack<E> push(E head) {
        if (isEmpty()) {
            reset(head, null);
        } else {
            reset(head, new Stack<>(getHead(), getTail().getTail()));
        }
        return this;
    }
    
    public E pop() {
        if (isEmpty()) return null;
        
        E head = getHead();
        if (hasTail()) {
            reset(getTail().getHead(), getTail().getTail());
        } else {
            reset(null, null);
        }
        return head;
    }
    
    public E getHead() {
        return head;
    }
    
    public Stack<E> getTail() {
        return tail;
    }
    
    public int getSize() {
        if (isEmpty()) return 0;
        if (!hasTail()) return 1;
        return 1 + getTail().getSize();
    }
    
    private void setHead(E head) {
        this.head = head;
    }
    
    private void reset(E head, Stack<E> tail) {
        setHead(head);
        setTail(tail);
    }
    
    public boolean isEmpty() {
        return getHead() == null && !hasTail();
    }
    
    public boolean hasTail() {
        return getTail() != null;
    }
    
    public void setTail(Stack<E> tail) {
        this.tail = tail;
    }
}
