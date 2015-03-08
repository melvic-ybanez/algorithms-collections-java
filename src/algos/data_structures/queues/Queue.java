package algos.data_structures.queues;

import java.util.Objects;

/**
 * Created by ybamelcash on 3/7/2015.
 */
public class Queue<E> {
    private E head;
    private Queue<E> tail;
    private Queue<E> last;
    
    public Queue(E head, Queue<E> tail) {
        reset(head, tail, tail);
    }
    
    public Queue(E head) {
        reset(head, null, null);
    }
    
    public Queue(E... elems) {
        for (E elem : elems) {
            enqueue(elem);
        }
    }
    
    public Queue() {}
    
    public Queue<E> enqueue(E head) {
        if (isEmpty()) {
            setHead(head);
        } else if (!hasTail()) { 
            setTail(new Queue<>(head));
            setLast(getTail());
        } else {
            last.setTail(new Queue<>(head));
            setLast(last.getTail());
        }
        return this;
    }
    
    public E dequeue() {
        E head = getHead();
        if (hasTail()) {
            Queue<E> newTail = getTail().getTail();
            reset(getTail().getHead(), newTail, newTail);
        } else clear();
        return head;
    }
    
    public int getSize() {
        if (isEmpty()) return 0;
        return 1 + (hasTail()? getTail().getSize() : 0);
    }
    
    private void reset(E head, Queue<E> tail, Queue<E> last) {
        setHead(head);
        setTail(tail);
        setLast(last);
    }
    
    private void clear() {
        reset(null, null, null);
    }
    
    public E getHead() {
        return head;
    }
    
    public Queue<E> getTail() {
        return tail;
    }
    
    public boolean hasTail() {
        return getTail() != null;
    }
    
    public void setHead(E head) {
        this.head = head;
    }
    
    public void setTail(Queue<E> tail) {
        this.tail = tail;
    }
    
    private void setLast(Queue<E> last) {
        this.last = last;
    }
    
    public boolean isEmpty() {
        return getHead() == null && !hasTail(); 
    }    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Queue<E> that = (Queue<E>) obj;
        boolean equalHeads = Objects.equals(this.getHead(), that.getHead());
        boolean equalTails = Objects.equals(this.getTail(), that.getTail());
        return equalHeads && equalTails;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "";
        return (Objects.toString(getHead(), "") + " " + 
                Objects.toString(getTail(), "")).trim();
    }
}
