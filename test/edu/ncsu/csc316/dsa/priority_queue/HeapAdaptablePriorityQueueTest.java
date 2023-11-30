package edu.ncsu.csc316.dsa.priority_queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;
import edu.ncsu.csc316.dsa.priority_queue.PriorityQueue.Entry;

/**
 * Test class for HeapAdaptablePriorityQueue
 * Checks the expected outputs of the Adaptable Priorty Queue abstract
 * data type behaviors when using a min-heap data structure 
 *
 * @author Dr. King
 *
 */
public class HeapAdaptablePriorityQueueTest {

    private HeapAdaptablePriorityQueue<Integer, String> heap;
    
    /**
     * Create a new instance of a heap before each test case executes
     */   
    @Before
    public void setUp() {
        heap = new HeapAdaptablePriorityQueue<Integer, String>();
    }
    
    /**
     * Test the output of the replaceKey behavior
     */     
    @Test
    public void testReplaceKey() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        Entry<Integer, String> e8 = heap.insert(8, "eight");
        Entry<Integer, String> e7 = heap.insert(7, "seven");
        Entry<Integer, String> e6 = heap.insert(6, "six");
        Entry<Integer, String> e5 = heap.insert(5, "five");
        Entry<Integer, String> e4 = heap.insert(4, "four");
        Entry<Integer, String> e3 = heap.insert(3, "three");
        Entry<Integer, String> e2 = heap.insert(2, "two");
        Entry<Integer, String> e1 = heap.insert(1, "one");
        Entry<Integer, String> e0 = heap.insert(0, "zero");
        assertEquals(9, heap.size());
        
        heap.replaceKey(e8,  -5);
        assertEquals(-5, (int)heap.min().getKey());
        assertEquals("eight", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e7,  -6);
        assertEquals(-6, (int)heap.min().getKey());
        assertEquals("seven", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e6,  -7);
        assertEquals(-7, (int)heap.min().getKey());
        assertEquals("six", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e5,  -8);
        assertEquals(-8, (int)heap.min().getKey());
        assertEquals("five", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e4,  -9);
        assertEquals(-9, (int)heap.min().getKey());
        assertEquals("four", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e3,  -10);
        assertEquals(-10, (int)heap.min().getKey());
        assertEquals("three", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e2,  -11);
        assertEquals(-11, (int)heap.min().getKey());
        assertEquals("two", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e1,  -12);
        assertEquals(-12, (int)heap.min().getKey());
        assertEquals("one", heap.min().getValue());
        assertEquals(9, heap.size());
        
        heap.replaceKey(e0,  -13);
        assertEquals(-13, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        
    }
    
    /**
     * Test the output of the replaceValue behavior
     */ 
    @Test
    public void testReplaceValue() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        Entry<Integer, String> e8 = heap.insert(8, "eight");
        Entry<Integer, String> e7 = heap.insert(7, "seven");
        Entry<Integer, String> e6 = heap.insert(6, "six");
        Entry<Integer, String> e5 = heap.insert(5, "five");
        Entry<Integer, String> e4 = heap.insert(4, "four");
        Entry<Integer, String> e3 = heap.insert(3, "three");
        Entry<Integer, String> e2 = heap.insert(2, "two");
        Entry<Integer, String> e1 = heap.insert(1, "one");
        Entry<Integer, String> e0 = heap.insert(0, "zero");
        assertEquals(9, heap.size());
        
        heap.replaceValue(e8,  "EIGHT");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("EIGHT",  e8.getValue());
        
        heap.replaceValue(e7,  "SEVEN");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("SEVEN",  e7.getValue());
        
        heap.replaceValue(e6,  "SIX");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("SIX",  e6.getValue());
        
        
        heap.replaceValue(e5,  "FIVE");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("FIVE",  e5.getValue());
        
        heap.replaceValue(e4,  "FOUR");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("FOUR",  e4.getValue());
        
        heap.replaceValue(e3,  "THREE");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("THREE",  e3.getValue());
        
        heap.replaceValue(e2,  "TWO");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("TWO",  e2.getValue());
        
        heap.replaceValue(e1,  "ONE");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("zero", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("ONE",  e1.getValue());
        
        heap.replaceValue(e0,  "ZERO");
        assertEquals(0, (int)heap.min().getKey());
        assertEquals("ZERO", heap.min().getValue());
        assertEquals(9, heap.size());
        assertEquals("ZERO",  e0.getValue());
        
  
    }

    /**
     * Test the output of the remove behavior
     */ 
    @Test
    public void testRemove() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        Entry<Integer, String> e8 = heap.insert(8, "eight");
        Entry<Integer, String> e7 = heap.insert(7, "seven");
        Entry<Integer, String> e6 = heap.insert(6, "six");
        Entry<Integer, String> e5 = heap.insert(5, "five");
        Entry<Integer, String> e4 = heap.insert(4, "four");
        Entry<Integer, String> e3 = heap.insert(3, "three");
        Entry<Integer, String> e2 = heap.insert(2, "two");
        Entry<Integer, String> e1 = heap.insert(1, "one");
        Entry<Integer, String> e0 = heap.insert(0, "zero");
        assertEquals(9, heap.size());
        
        heap.remove(e0);
        assertEquals(1, (int)heap.min().getKey());
        assertEquals("one", heap.min().getValue());
        assertEquals(8, heap.size());
        
        heap.remove(e1);
        assertEquals(2, (int)heap.min().getKey());
        assertEquals("two", heap.min().getValue());
        assertEquals(7, heap.size());
        
        heap.remove(e2);
        assertEquals(3, (int)heap.min().getKey());
        assertEquals("three", heap.min().getValue());
        assertEquals(6, heap.size());
        
        heap.remove(e3);
        assertEquals(4, (int)heap.min().getKey());
        assertEquals("four", heap.min().getValue());
        assertEquals(5, heap.size());
        
        heap.remove(e4);
        assertEquals(5, (int)heap.min().getKey());
        assertEquals("five", heap.min().getValue());
        assertEquals(4, heap.size());
        
        heap.remove(e5);
        assertEquals(6, (int)heap.min().getKey());
        assertEquals("six", heap.min().getValue());
        assertEquals(3, heap.size());
        
        heap.remove(e6);
        assertEquals(7, (int)heap.min().getKey());
        assertEquals("seven", heap.min().getValue());
        assertEquals(2, heap.size());
        
        heap.remove(e7);
        assertEquals(8, (int)heap.min().getKey());
        assertEquals("eight", heap.min().getValue());
        assertEquals(1, heap.size());
        
        heap.remove(e8);
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
    }
    
    /**
     * Test the output of the heap behavior when using arbitrary key objects to
     * represent priorities
     */     
    @Test
    public void testStudentHeap() {
        AdaptablePriorityQueue<Student, String> sHeap = new HeapAdaptablePriorityQueue<Student, String>(new StudentIDComparator());
        Student s1 = new Student("J", "K", 1, 1, 1, "jk1");
        Student s2 = new Student("J", "S", 2, 1, 2, "js2");
        Student s3 = new Student("S", "H", 3, 1, 3, "sh3");
        Student s4 = new Student("J", "J", 4, 1, 4, "jj4");
        Student s5 = new Student("L", "B", 5, 1, 5, "lb5");
        
        assertTrue(sHeap.isEmpty());
        assertEquals(0, sHeap.size());
        
        Entry<Student, String> sOne = sHeap.insert(s1, s1.toString());
        assertEquals(1, sHeap.size());
        Entry<Student, String> sTwo = sHeap.insert(s2, s2.toString());
        assertEquals(2, sHeap.size());
        Entry<Student, String> sThree = sHeap.insert(s3, s3.toString());
        assertEquals(3, sHeap.size());
        Entry<Student, String> sFour = sHeap.insert(s4, s4.toString());
        assertEquals(4, sHeap.size());
        Entry<Student, String> sFive = sHeap.insert(s5, s5.toString());
        assertEquals(5, sHeap.size());
        
        assertEquals(s1, (Student)sHeap.min().getKey());
        sHeap.remove(sOne);
        assertEquals(s2, (Student)sHeap.min().getKey());
        sHeap.remove(sTwo);
        assertEquals(s3, (Student)sHeap.min().getKey());
        sHeap.remove(sThree);
        assertEquals(s4, (Student)sHeap.min().getKey());
        sHeap.remove(sFour);
        assertEquals(s5, (Student)sHeap.min().getKey());
        
        sHeap.replaceValue(sFive,  s1.toString());
        assertEquals(s5, (Student)sHeap.min().getKey());
        assertEquals(s1.toString(), sHeap.min().getValue());
        assertEquals(s1.toString(),  sFive.getValue());
        
        sHeap.replaceKey(sFive, s1);
        
        
        
        
    }
}