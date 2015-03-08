package algos.tests;

import algos.data_structures.queues.Queue;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by ybamelcash on 3/8/2015.
 */
public class QueueTest {
    private Queue<Integer> emptyQueue;
    private Queue<Integer> taillessQueue;
    private Queue<Integer> tailedQueue;
    private Queue<Integer> threeElementQueue;
    
    @Before
    public void createEmptyQueue() {
        emptyQueue = new Queue<>();
        taillessQueue = new Queue<>(1);
        tailedQueue = new Queue<>();
        tailedQueue.enqueue(1).enqueue(2);
        threeElementQueue = new Queue<>();
        threeElementQueue.enqueue(1).enqueue(2).enqueue(3);
    }
    
    @Test
    public void testTwoEmptyQueuesEquality() {
        assertEquals(emptyQueue, new Queue<>()); 
    }
    
    @Test
    public void testEmptyAndNonEmptyQueuesInequality() {
        assertNotEquals(taillessQueue, new Queue<>());
    }
    
    @Test
    public void testTaillessQueuesEquality() {
        assertEquals(taillessQueue, new Queue<>(1));
    }
    
    @Test
    public void testTaillessQueuesInequality() {
        assertNotEquals(taillessQueue, new Queue<>(2));
    }
    
    @Test
    public void testTaillessAndTailedQueuesInequality() {
        assertNotEquals(taillessQueue, new Queue<>(2, 1));
    } 
    
    @Test
    public void testTailedQueuesEquality() {
        assertEquals(threeElementQueue, new Queue<>(1, 2, 3));
    }
    
    @Test
    public void testTailedQueuesInequality() {
        assertNotEquals(threeElementQueue, new Queue<>(1, 3, 2));
    }
    
    @Test
    public void testEmptyQueueToString() {
        assertEquals("", emptyQueue.toString());
    }
    
    @Test
    public void testTaillessQueueToString() {
        assertEquals("1", taillessQueue.toString());
    }
    
    @Test
    public void testTailedQueueToString() {
        assertEquals("1 2 3", threeElementQueue.toString());
    }
    
    @Test
    public void testEmptySize() {
        assertEquals(0, emptyQueue.getSize());
    }
    
    @Test
    public void testTaillessSize() {
        assertEquals(1, taillessQueue.getSize());
    }
    
    @Test
    public void testEnqueueSize() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(1).enqueue(2).enqueue(3);
        assertEquals(3, q.getSize());
    }
    
    @Test
    public void testEnqueueElements() {
        assertEquals("1 2 3", threeElementQueue.toString());
    }
    
    @Test
    public void testDequeueEmptyQueueSize() {
        emptyQueue.dequeue();
        assertEquals(0, emptyQueue.getSize());
    }
    
    @Test
    public void testDequeueTaillessQueueSize() {
        taillessQueue.dequeue();
        assertEquals(0, emptyQueue.getSize());
    }
    
    @Test
    public void testDequeueThreeElementQueueSize() {
        threeElementQueue.dequeue();
        assertEquals(2, threeElementQueue.getSize());
    }
    
    @Test
    public void testDequeueEmptyQueueElements() {
        emptyQueue.dequeue();
        assertEquals("", emptyQueue.toString());
    }
    
    @Test
    public void testDequeueTaillessQueueElements() {
        taillessQueue.dequeue();
        assertEquals("", taillessQueue.toString());
    }
    
    @Test
    public void testDequeueTailedElements() {
        tailedQueue.dequeue();
        assertEquals("2", tailedQueue.toString());
    }
    
    @Test
    public void testDequeueThreeElementQueueElements() {
        threeElementQueue.dequeue();
        assertEquals("2 3", threeElementQueue.toString());
    }
    
    @Test
    public void testThreeDequeueThreeElementQueueElements() {
        threeElementQueue.dequeue();
        threeElementQueue.dequeue();
        threeElementQueue.dequeue();
        assertEquals(emptyQueue, threeElementQueue);
    }
    
    @Test
    public void testDequeueEmptyQueueResult() {
        assertEquals(null, emptyQueue.dequeue());
    }
    
    @Test
    public void testDequeueTaillessQueueResult() {
        assertEquals(new Integer(1), taillessQueue.dequeue());
    }
    
    @Test
    public void testDequeueTailedQueueResult() {
        assertEquals(new Integer(1), tailedQueue.dequeue());
    }
    
    @Test
    public void testDequeueThreeElementResult() {
        assertEquals(new Integer(1), threeElementQueue.dequeue());
    }
}
