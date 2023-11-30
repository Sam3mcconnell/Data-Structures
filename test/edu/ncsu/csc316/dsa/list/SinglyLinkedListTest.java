package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {

	private SinglyLinkedList<String> list;

    /**
     * Create a new instance of an array-based list before each test case executes
     */
    @Before
    public void setUp() {
        list = new SinglyLinkedList<String>();
    }
    
    @Test
    public void testAddIndex() {
    	list.add(0, "zero");
    	list.add(1, "one");
    	list.add(2, "two");
    	
    	assertEquals("zero", list.get(0));
    	assertEquals("one", list.get(1));
    	assertEquals("two", list.get(2));
    	assertEquals(3, list.size());
    	
    	list.add(0, "four");
    	
    	assertEquals("four", list.get(0));
    	assertEquals("zero", list.get(1)); 
    	assertEquals("one", list.get(2));
    	assertEquals("two", list.get(3));
    	assertEquals(4, list.size());
    	
    	list.add(2, "five");
    	
    	assertEquals("four", list.get(0));
    	assertEquals("zero", list.get(1));
    	assertEquals("five", list.get(2));
    	assertEquals("one", list.get(3));
    	assertEquals("two", list.get(4));
    	assertEquals(5, list.size());
    	
    	try{
            list.add(15,  "fifteen");
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        
        try{
            list.add(-1, "five");
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }
    
    /**
     * Test the output of the addLast behavior
     */
    @Test
    public void testAddLast() {
        list.addLast("one");
        list.addLast("two");
        list.addLast("three");
        list.addLast("four");
        
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertEquals("four", list.get(3));
    }

    /**
     * Test the output of the last() behavior, including expected exceptions
     */
    @Test
    public void testLast() {
    	list.addLast("one");
        list.addLast("two");
        list.addLast("three");
        list.addLast("four");
        
        assertEquals("four", list.last());
    }

    /**
     * Test the output of the addFirst behavior
     */
    @Test
    public void testAddFirst() {
    	list.addFirst("one");
        list.addFirst("two");
        list.addFirst("three");
        list.addFirst("four");
        
        assertEquals("four", list.get(0));
        assertEquals("three", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("one", list.get(3));
    }

    /**
     * Test the output of the first() behavior, including expected exceptions
     */
    @Test
    public void testFirst() {
    	list.addFirst("one");
        list.addFirst("two");
        list.addFirst("three");
        list.addFirst("four");
        
        assertEquals("four", list.first());
    }

    /**
     * Test the iterator behaviors, including expected exceptions
     */
    @Test
    public void testIterator() {
        // Start with an empty list
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        
        // Create an iterator for the empty list
        Iterator<String> it = list.iterator();
        	
        assertFalse(it.hasNext());

        
        // Now add an element
        list.addLast("one");
        
        // Use accessor methods to check that the list is correct
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals("one", list.get(0)); 
        
        // Create an iterator for the list that has 1 element
        it = list.iterator();
        
        // Try different iterator operations to make sure they work
        // as expected for a list that contains 1 element (at this point)
        assertTrue(it.hasNext());
        assertEquals("one", it.next());
        assertFalse(it.hasNext());
        
        try{
            it.next();
            fail("A NoSuchElementException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }

        list.addLast("two");
        
        it = list.iterator();
        
        assertTrue(it.hasNext());
        assertEquals("one", it.next());
        assertTrue(it.hasNext());
        assertEquals("two", it.next());
        assertFalse(it.hasNext());
        try{
            it.next();
            fail("A NoSuchElementException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
        
    }

    /**
     * Test the output of the remove(index) behavior, including expected exceptions
     */
    @Test
    public void testRemoveIndex() {
        list.add(0, "zero");
        list.add(1, "one");
        list.add(2, "two");
        list.add(3, "three");
        list.add(4, "four");
        list.add(5, "five");
        
        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("three", list.get(3));
        assertEquals("four", list.get(4));
        assertEquals("five", list.get(5));
        
        assertEquals("three", list.remove(3));
        
        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("four", list.get(3));
        assertEquals("five", list.get(4));
        
        assertEquals("zero", list.remove(0));
        
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("four", list.get(2));
        assertEquals("five", list.get(3));
        
        assertEquals("five", list.remove(3));
        
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("four", list.get(2));
        
        try{
            list.remove(15);
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        
        try{
            list.remove(-1);
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        
    }

    /**
     * Test the output of the removeFirst() behavior, including expected exceptions
     */
    @Test
    public void testRemoveFirst() {
    	list.add(0, "zero");
        list.add(1, "one");
        list.add(2, "two");
        list.add(3, "three");
        list.add(4, "four");
        list.add(5, "five");
        
        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("three", list.get(3));
        assertEquals("four", list.get(4));
        assertEquals("five", list.get(5));
        
        assertEquals("zero", list.removeFirst());
        
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertEquals("four", list.get(3));
        assertEquals("five", list.get(4));
    }

    /**
     * Test the output of the removeLast() behavior, including expected exceptions
     */
    @Test
    public void testRemoveLast() {
    	list.add(0, "zero");
        list.add(1, "one");
        list.add(2, "two");
        list.add(3, "three");
        list.add(4, "four");
        list.add(5, "five");
        
        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("three", list.get(3));
        assertEquals("four", list.get(4));
        assertEquals("five", list.get(5));
        
        assertEquals(6, list.size());
        
        assertEquals("five", list.removeLast());
        
        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("three", list.get(3));
        assertEquals("four", list.get(4));
        
        assertEquals(5, list.size());
        
    }

    /**
     * Test the output of the set(index, e) behavior, including expected exceptions
     */
    @Test
    public void testSet() {
    	list.add(0, "zero");
        list.add(1, "one");
        list.add(2, "two");
        list.add(3, "three");
        list.add(4, "four");
        list.add(5, "five");
        
        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("three", list.get(3));
        assertEquals("four", list.get(4));
        assertEquals("five", list.get(5));
        
        assertEquals("three", list.set(3, "six"));
        
        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("six", list.get(3));
        assertEquals("four", list.get(4));
        assertEquals("five", list.get(5));
        
        assertEquals("zero", list.set(0, "seven"));
        
        assertEquals("seven", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("six", list.get(3));
        assertEquals("four", list.get(4));
        assertEquals("five", list.get(5));
        
        assertEquals("five", list.set(5, "eight"));
        
        assertEquals("seven", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("six", list.get(3));
        assertEquals("four", list.get(4));
        assertEquals("eight", list.get(5));
        
        try{
            list.set(-1, "five");
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) { 
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
         
        try{
            list.set(20, "five");
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        
    }
}

