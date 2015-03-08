package algos.tests;

import algos.data_structures.queues.Queue;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by ybamelcash on 3/8/2015.
 */
public class QueueTest {
    @Test
    public void testTwoEmptyQueuesEquality() {
        assertEquals(new Queue<>(), new Queue<>()); 
    }
    
    @Test
    public void testEmptyAndNonEmptyQueuesInequality() {
        assertNotEquals(new Queue<>(1), new Queue<>());
    }
    
    @Test
    public void testTaillessQueuesEquality() {
        assertEquals(new Queue<>(1), new Queue<>(1));
    }
    
    @Test
    public void testTaillessQueuesInequality() {
        assertNotEquals(new Queue<>(1), new Queue<>(2));
    }
    
    @Test
    public void testTaillessAndTailedQueuesInequality() {
        assertNotEquals(new Queue<>(1), new Queue<>(2, 1));
    } 
    
    @Test
    public void testTailedQueuesEquality() {
        assertEquals(new Queue<>(1, 2, 3), new Queue<>(1, 2, 3));
    }
    
    @Test
    public void testTailedQueuesInequality() {
        assertNotEquals(new Queue<>(1, 2, 3), new Queue<>(1, 3, 2));
    }
    
    @Test
    public void testEmptyQueueToString() {
        assertEquals("", new Queue<>().toString());
    }
    
    @Test
    public void testTaillessQueueToString() {
        assertEquals("1", new Queue<>(1).toString());
    }
    
    @Test
    public void testTailedQueueToString() {
        assertEquals("1 2 3", new Queue<>(1, 2, 3).toString());
    }
}
