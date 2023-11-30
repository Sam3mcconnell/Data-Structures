package edu.ncsu.csc316.dsa.list.positional;

import static org.junit.Assert.*; 

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for PositionalLinkedList.
 * Checks the expected outputs of the Positional List abstract data type behaviors when using
 * an doubly-linked positional list data structure
 *
 * @author Dr. King
 *
 */
public class PositionalLinkedListTest {

    private PositionalList<String> list;
    
    /**
     * Create a new instance of an positional linked list before each test case executes
     */ 
    @Before
    public void setUp() {
        list = new PositionalLinkedList<String>();
    }
    
    /**
     * Test the output of the first() behavior, including expected exceptions
     */
    @Test
    public void testFirst() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        
        assertNull(list.first());
        
        Position<String> first = list.addFirst("one");
        assertEquals(1, list.size());
        assertEquals(first, list.first());
        Position<String> firstTwo = list.addFirst("two");
        assertEquals(2, list.size());
        assertEquals(firstTwo, list.first());
        
    }
    
    /**
     * Test the output of the last() behavior, including expected exceptions
     */
    @Test
    public void testLast() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        
        assertNull(list.last());
        Position<String> last = list.addLast("one");
        assertEquals(1, list.size());
        assertEquals(last, list.last());
        Position<String> lastTwo = list.addLast("two");
        assertEquals(2, list.size());
        assertEquals(lastTwo, list.last());
        
    }
    
    /**
     * Test the output of the addFirst(element) behavior
     */ 
    @Test
    public void testAddFirst() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> first = list.addFirst("one");
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals(first, list.first());
        assertEquals(list.addFirst("two"), list.first());
        assertEquals(2, list.size());
        assertEquals("two", list.first().getElement());
    }
    
    /**
     * Test the output of the addLast(element) behavior
     */ 
    @Test
    public void testAddLast() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> last = list.addLast("one");
        assertEquals(1, list.size());
        assertEquals(last, list.last());
        
        assertEquals(list.addLast("two"), list.last());
        assertEquals(2, list.size());
        assertEquals("two", list.last().getElement());
    }
    
    /**
     * Test the output of the before(position) behavior, including expected exceptions
     */ 
    @Test
    public void testBefore() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> first = list.addLast("one");
        Position<String> last = list.addLast("three");
        assertEquals(2, list.size());
        assertEquals(first, list.first());
        assertEquals(last, list.last());
        Position<String> before = list.before(last);
        assertEquals(first, before);
        
        Position<String> before2 = list.before(first);
        assertEquals(null, before2);
        
        
    } 
    
    /**
     * Test the output of the after(position) behavior, including expected exceptions
     */     
    @Test
    public void testAfter() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> first = list.addLast("one");
        Position<String> last = list.addLast("three");
        assertEquals(2, list.size());
        assertEquals(first, list.first());
        assertEquals(last, list.last());
        Position<String> after = list.after(first);
        assertEquals(last, after);
        
        Position<String> after2 = list.after(last);
        assertEquals(null, after2);
    }
    
    /**
     * Test the output of the addBefore(position, element) behavior, including expected exceptions
     */     
    @Test
    public void testAddBefore() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> first = list.addLast("one");
        Position<String> last = list.addLast("three");
        assertEquals(2, list.size());
        assertEquals(first, list.first());
        assertEquals(last, list.last());
        Position<String> before = list.addBefore(last, "two");
        assertEquals(before, list.before(last));
        assertEquals(before, list.after(first));
        
    }
    
    /**
     * Test the output of the addAfter(position, element) behavior, including expected exceptions
     */     
    @Test
    public void testAddAfter() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> first = list.addLast("one");
        Position<String> last = list.addLast("three");
        assertEquals(2, list.size());
        assertEquals(first, list.first());
        assertEquals(last, list.last());
        Position<String> after = list.addAfter(first, "two");
        assertEquals(after, list.after(first));
        assertEquals(after, list.before(last));
        
        
    }
    
    /**
     * Test the output of the set(position, element) behavior, including expected exceptions
     */     
    @Test
    public void testSet() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> first = list.addLast("one");
        Position<String> last = list.addLast("three");
        assertEquals(2, list.size());
        assertEquals(first, list.first());
        assertEquals(last, list.last());
        assertEquals("one", list.set(first, "two"));
        assertEquals("two", first.getElement()); 
        
        
        
    }
    
    /**
     * Test the output of the remove(position) behavior, including expected exceptions
     */     
    @Test
    public void testRemove() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> first = list.addLast("one");
        Position<String> last = list.addLast("three");
        assertEquals(2, list.size());
        assertEquals(first, list.first());
        assertEquals(last, list.last());
        Position<String> after = list.addAfter(first, "two");
        assertEquals(after, list.after(first));
        assertEquals(after, list.before(last));
        assertEquals(3, list.size());
        assertEquals("two", list.remove(after));
        assertEquals(2, list.size());
        assertEquals(first, list.before(last));
        assertEquals(last, list.after(first));
        
        
    }
    
    /**
     * Test the output of the iterator behavior for elements in the list, 
     * including expected exceptions
     */     
    @Test
    public void testIterator() {
     
    	// Start with an empty list
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        
        // Create an iterator for the empty list
        Iterator<String> it = list.iterator(); 
        
        try{
            it.remove();
            fail("An IllegalStateException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof IllegalStateException); 
        }
        
        list.addLast("one");
        list.addLast("two");
        
        // Use accessor methods to check that the list is correct
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
        assertEquals("one", list.first().getElement());
        assertEquals("two", list.last().getElement());
        
        // Create an iterator for the list that has 1 element
        it = list.iterator();
        
        // Try different iterator operations to make sure they work
        // as expected for a list that contains 1 element (at this point)
        assertTrue(it.hasNext());
        assertEquals("one", it.next());
        assertTrue(it.hasNext());
        assertEquals("two", it.next());
        
        
        try{
            it.next();
            fail("A NoSuchElementException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
        
        list.addLast("three");
        list.addLast("four");
        assertEquals(4, list.size());
        
     // Create an iterator for the list that has 3 element
        it = list.iterator();
        
        assertTrue(it.hasNext());
        assertEquals("one", it.next());
        assertTrue(it.hasNext());
        assertEquals("two", it.next());
        it.remove();
        assertTrue(it.hasNext());
        assertEquals("three", it.next());
        assertEquals("four", it.next());
        assertFalse(it.hasNext());
      
        
        
    }
    
    
    /**
     * Test the output of the positions() behavior to iterate through positions
     * in the list, including expected exceptions
     */     
    @Test
    public void testPositions() {
        assertEquals(0, list.size());
        Position<String> first = list.addFirst("one");
        Position<String> second = list.addLast("two");
        Position<String> third = list.addLast("three");
        assertEquals(3, list.size());
        
        Iterator<Position<String>> it = list.positions().iterator();
        assertTrue(it.hasNext());
        assertEquals(first, it.next());
        assertEquals(second, it.next());
        assertEquals(third, it.next());
        
    }

}