package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for UnorderedLinkedMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an unordered link-based list data structure that uses the move-to-front heuristic for
 * self-organizing entries based on access frequency
 *
 * @author Dr. King
 *
 */
public class UnorderedLinkedMapTest {

    private Map<Integer, String> map;
    
    /**
     * Create a new instance of an unordered link-based map before each test case executes
     */     
    @Before
    public void setUp() {
        map = new UnorderedLinkedMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertEquals("UnorderedLinkedMap[3]", map.toString());
        assertEquals(1, map.size()); 

        assertEquals("string3", map.put(3, "string4"));
        
        assertEquals("UnorderedLinkedMap[3]", map.toString());
        assertEquals(1, map.size());
    }
 
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals("string5", map.get(5));
        assertEquals("UnorderedLinkedMap[5, 1, 4, 2, 3]", map.toString());
        
        assertEquals(null, map.get(7));
        assertEquals("UnorderedLinkedMap[5, 1, 4, 2, 3]", map.toString());
 
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals("string5", map.remove(5));
        assertEquals("UnorderedLinkedMap[1, 4, 2, 3]", map.toString());
        
        assertNull(map.remove(7));
    }

    /**
     * Test the output of the iterator behavior, including expected exceptions
     */     
    @Test
    public void testIterator() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1")); 
        
        Iterator<Integer> it = map.iterator();
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;

        try{
            it.remove();
            fail("An IllegalStateException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof UnsupportedOperationException); 
        }
        
        assertTrue(it.hasNext());
        assertEquals(one, it.next());
        assertTrue(it.hasNext());
        assertEquals(four, it.next());
        assertTrue(it.hasNext());
        assertEquals(two, it.next());
        assertTrue(it.hasNext());
        assertEquals(five, it.next());
        assertTrue(it.hasNext());
        assertEquals(three, it.next());
        assertFalse(it.hasNext());
    }

    /**
     * Test the output of the entrySet() behavior, including expected exceptions
     */     
    @Test
    public void testEntrySet() {
        assertNull(map.put(3, "string3")); 
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        

    }

    /**
     * Test the output of the values() behavior, including expected exceptions
     */     
    @Test
    public void testValues() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        Iterable<String> iterator = map.values();
        Iterator<String> it = iterator.iterator();
        
        try{
            it.remove();
            fail("An IllegalStateException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof UnsupportedOperationException); 
        }
        
        assertTrue(it.hasNext());
        assertEquals("string1", it.next());
        assertTrue(it.hasNext());
        assertEquals("string4", it.next());
        assertTrue(it.hasNext());
        assertEquals("string2", it.next());
        assertTrue(it.hasNext());
        assertEquals("string5", it.next());
        assertTrue(it.hasNext());
        assertEquals("string3", it.next());
        assertFalse(it.hasNext());
        
        
    }
}