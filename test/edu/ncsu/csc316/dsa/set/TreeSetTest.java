package edu.ncsu.csc316.dsa.set;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for TreeSet
 * Checks the expected outputs of the Set abstract data type behaviors when using
 * a balanced search tree data structure 
 *
 * @author Dr. King
 *
 */
public class TreeSetTest {

    private Set<Integer> set;

    /**
     * Create a new instance of a tree-based set before each test case executes
     */      
    @Before
    public void setUp() {
        set = new TreeSet<Integer>(); 
    }

    /**
     * Test the output of the add behavior
     */     
    @Test
    public void testAdd() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        
        set.add(5);
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
        set.add(10);
        set.add(15);
        set.add(20);
        set.add(25);
        
        assertEquals(5, set.size());
        
    }

    /**
     * Test the output of the contains behavior
     */ 
    @Test
    public void testContains() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(20);
        set.add(25);
        assertEquals(5, set.size());

        assertTrue(set.contains(10));
        assertFalse(set.contains(23));
    }

    /**
     * Test the output of the remove behavior
     */ 
    @Test
    public void testRemove() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(20);
        set.add(25);
        assertEquals(5, set.size());
        
        assertEquals(10, (int)set.remove(10));
        assertEquals(4, set.size());
        
    }
    
    /**
     * Test the output of the retainAll behavior
     */ 
    @Test
    public void testRetainAll() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(20);
        set.add(25);
        assertEquals(5, set.size());
        
        Set<Integer> other = new TreeSet<Integer>();
        other.add(10);
        other.add(20);
        other.add(30);
        assertTrue(other.contains(10));
        assertTrue(other.contains(20));
        assertTrue(other.contains(30));
        assertEquals(3, other.size());
        
        other.retainAll(set);
        assertEquals(2, other.size());
        assertTrue(other.contains(10));
        assertTrue(other.contains(20));
        assertFalse(other.contains(30));
        
       
    }

    /**
     * Test the output of the removeAll behavior
     */     
    @Test
    public void testRemoveAll() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(20);
        set.add(25);
        assertEquals(5, set.size());
        
        Set<Integer> other = new TreeSet<Integer>();
        other.add(10);
        other.add(20);
        other.add(30);
        assertTrue(other.contains(10));
        assertTrue(other.contains(20));
        assertTrue(other.contains(30));
        assertEquals(3, other.size());
        other.removeAll(other);
        assertEquals(0, other.size());
        assertFalse(other.contains(20));
        assertFalse(other.contains(10));
        assertFalse(other.contains(30));
        
        
        
    }

    /**
     * Test the output of the addAll behavior
     */     
    @Test
    public void testAddAll() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(20);
        set.add(25);
        assertEquals(5, set.size());
        
        Set<Integer> other = new TreeSet<Integer>();
        other.add(30);
        other.add(40);
        other.add(50);
        
        assertFalse(other.contains(5));
        assertFalse(other.contains(10));
        assertFalse(other.contains(15));
        assertFalse(other.contains(20));
        assertFalse(other.contains(25));
        other.addAll(set);
        assertTrue(other.contains(5));
        assertTrue(other.contains(10));
        assertTrue(other.contains(15));
        assertTrue(other.contains(20));
        assertTrue(other.contains(25));
        
    }

    /**
     * Test the output of the iterator behavior
     */ 
    @Test
    public void testIterator() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add(5); 
        set.add(10);
        set.add(15);        
        set.add(20);        
        set.add(25);
        assertEquals(5, set.size());
        Iterator<Integer> it = set.iterator();
        
        assertTrue(it.hasNext());
        assertEquals(5, (int)it.next());
        assertTrue(it.hasNext());
        assertEquals(10, (int)it.next());
        assertTrue(it.hasNext());
        assertEquals(15, (int)it.next());
        assertTrue(it.hasNext());
        assertEquals(20, (int)it.next());
        assertTrue(it.hasNext());
        assertEquals(25, (int)it.next());
        assertFalse(it.hasNext());
        
    }
}