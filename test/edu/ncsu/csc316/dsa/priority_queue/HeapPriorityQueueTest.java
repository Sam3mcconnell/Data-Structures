package edu.ncsu.csc316.dsa.priority_queue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for HeapPriorityQueue
 * Checks the expected outputs of the Priorty Queue abstract data type behaviors when using
 * a min-heap data structure 
 *
 * @author Dr. King
 *
 */
public class HeapPriorityQueueTest {

    private PriorityQueue<Integer, String> heap;
    
    /**
     * Create a new instance of a heap before each test case executes
     */     
    @Before
    public void setUp() {
        heap = new HeapPriorityQueue<Integer, String>();
    }
    
    /**
     * Test the output of the insert(k,v) behavior
     */     
    @Test
    public void testInsert() {
        assertTrue(heap.isEmpty());
        assertTrue(heap.size() == 0);
        
        heap.insert(8, "eight");
        assertEquals(1, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(8, (int)heap.min().getKey());
        
        heap.insert(4, "four");
        assertEquals(2, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(4, (int)heap.min().getKey());
        
    }
    
    /**
     * Test the output of the min behavior
     */ 
    @Test
    public void testMin() {
        assertTrue(heap.isEmpty());
        assertTrue(heap.size() == 0);
        
        assertNull(heap.min());
        
        heap.insert(8, "eight");
        assertEquals(1, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(8, (int)heap.min().getKey());
        
        heap.insert(4, "four");
        assertEquals(2, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(4, (int)heap.min().getKey());
        
        
    }
    
    /**
     * Test the output of the deleteMin behavior
     */     
    @Test 
    public void deleteMin() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        assertNull(heap.deleteMin());
        
        heap.insert(8, "eight");
        assertEquals(1, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(8, (int)heap.min().getKey());
        
        heap.insert(4, "four");
        assertEquals(2, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(4, (int)heap.min().getKey());
        
        heap.insert(2, "two");
        assertEquals(3, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(2, (int)heap.min().getKey());
        
        heap.insert(5, "five");
        assertEquals(4, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(2, (int)heap.min().getKey());
        
        heap.insert(7, "seven");
        assertEquals(5, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(2, (int)heap.min().getKey());
        
        assertEquals("two", heap.deleteMin().getValue());
        
    }
    
    /**
     * Test the output of the heap behavior when using arbitrary key objects to
     * represent priorities
     */ 
    @Test
    public void testStudentHeap() {
        PriorityQueue<Student, String> sHeap = new HeapPriorityQueue<Student, String>(new StudentIDComparator());
        Student s1 = new Student("J", "K", 1, 1, 1, "jk1");
        Student s2 = new Student("J", "S", 2, 1, 2, "js2");
        Student s3 = new Student("S", "H", 3, 1, 3, "sh3");
        Student s4 = new Student("J", "J", 4, 1, 4, "jj4");
        Student s5 = new Student("L", "B", 5, 1, 5, "lb5");
        
        assertTrue(sHeap.isEmpty());
        assertEquals(0, sHeap.size());
        
        sHeap.insert(s5, s5.toString());
        assertFalse(sHeap.isEmpty());
        assertEquals(1, sHeap.size());
        assertEquals(s5, (Student)sHeap.min().getKey());
         
        sHeap.insert(s4, s4.toString());
        assertFalse(sHeap.isEmpty());
        assertEquals(2, sHeap.size());
        assertEquals(s4, (Student)sHeap.min().getKey());
        
        sHeap.insert(s1, s1.toString());
        assertFalse(sHeap.isEmpty());
        assertEquals(3, sHeap.size());
        assertEquals(s1, (Student)sHeap.min().getKey());
        
        sHeap.insert(s2, s2.toString());
        assertFalse(sHeap.isEmpty());
        assertEquals(4, sHeap.size());
        assertEquals(s1, (Student)sHeap.min().getKey());
        
        sHeap.insert(s3, s3.toString());
        assertFalse(sHeap.isEmpty());
        assertEquals(5, sHeap.size());
        assertEquals(s1, (Student)sHeap.min().getKey());
        
        assertEquals(s1, sHeap.deleteMin().getKey());
        
        assertEquals(s2, (Student)sHeap.min().getKey());
        
        
        
    }
}