package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for BinarySearchTreeMap
 * Checks the expected outputs of the Map and Tree abstract data type behaviors when using
 * an linked binary tree data structure 
 *
 * @author Dr. King
 *
 */
public class BinarySearchTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a binary search tree map before each test case executes
     */
    @Before
    public void setUp() {
        tree = new BinarySearchTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size()); 
        assertTrue(tree.isEmpty());
        tree.put(1, "one");
        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty()); 
        assertEquals(1, (int)tree.root().getElement().getKey());
        
        tree.put(2, "two");
        assertEquals(2, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(2, (int)tree.right(tree.root()).getElement().getKey());
        
        tree.put(3, "two");
        assertEquals(3, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(3, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(4, "four");
        assertEquals(4, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(4, (int)tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());
        assertEquals("four", tree.get(4));
        
        tree.put(0, "zero");
        assertEquals(5, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(0, (int)tree.left(tree.root()).getElement().getKey());
        
        
        
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        assertEquals("one", tree.get(1));
        
        tree.put(4,  "four");
        assertEquals(2, tree.size());
        assertEquals("four", tree.get(4));
        assertEquals(null, tree.get(8));
        
    }

    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        
        assertNull(tree.remove(10));
        assertEquals(1, tree.size());
        
        assertEquals("one", tree.remove(1));
        assertEquals(0, tree.size());
        
        tree.put(3, "three");
        assertEquals(1, tree.size());
        
        tree.put(1, "one");
        assertEquals(2, tree.size());
        
        tree.put(2, "two");
        assertEquals(3, tree.size());
        
        tree.put(0, "zero");
        assertEquals(4, tree.size());
        
        assertEquals("one", tree.remove(1));
        assertEquals(3, tree.size());
        
        tree.put(4, "four");
        assertEquals(4, tree.size());
        
        tree.put(5, "five");
        assertEquals(5, tree.size());
        
        assertEquals("four", tree.remove(4));
        assertEquals(4, tree.size());
        
        tree.put(4, "four");
        assertEquals(5, tree.size());
        
        assertEquals("five", tree.remove(5));
        assertEquals(4, tree.size());
      
        tree.toString();
        tree.entrySet();
    }
    
    
}