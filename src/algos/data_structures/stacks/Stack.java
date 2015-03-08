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
    
    public Stack(E... elems) {
        for (E elem : elems) {
            push(elem);
        }
    }
    
    public Stack() {}
    
    public Stack<E> push(E head) {
        if (isEmpty()) {
            reset(head, null);
        } else {
            reset(head, new Stack<>(getHead(), getTail()));
        }
        return this;
    }
    
    public E pop() {
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
    
    public void setHead(E head) {
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Stack<E> that = (Stack<E>) obj;
        boolean equalHeads = this.getHead().equals(that.getHead());
        if (hasTail()) {
            boolean equalTails = getTail().equals(that.getTail());
            return equalHeads && equalTails;
        }
        return equalHeads && !that.hasTail();
    }

    @Override
    public String toString() {
        if (isEmpty()) return " ";
        String itemString = getHead().toString();
        if (hasTail())
            return itemString + " " + getTail();
        return itemString;
    }
}
