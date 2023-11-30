package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SplayTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a splay tree data structure 
 *
 * @author Dr. King
 *
 */
public class SplayTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a splay tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new SplayTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
    	assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(2, "two");
        assertEquals(1, tree.size());
        assertEquals(2, (int)tree.root().getElement().getKey());
        
        tree.put(1, "one");
        assertEquals(2, tree.size());
        assertEquals(1, (int)tree.root().getElement().getKey());
        assertEquals(2, (int)tree.right(tree.root()).getElement().getKey());
        
        tree.put(5, "five");
        assertEquals(3, tree.size());
        assertEquals(5, (int)tree.root().getElement().getKey());
        assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        
        tree.put(6, "six");
        assertEquals(4, tree.size());
        assertEquals(6, (int)tree.root().getElement().getKey());
        assertEquals(5, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(2, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.left(tree.left(tree.root()))).getElement().getKey());
        
        tree.put(7, "seven");
        assertEquals(5, tree.size());
        assertEquals(7, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(5, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int)tree.left(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.left(tree.left(tree.left(tree.root())))).getElement().getKey());
        
        
        tree.put(4, "four");
        assertEquals(6, tree.size());
        assertEquals(4, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(5, (int)tree.left(tree.right(tree.root())).getElement().getKey());    
    }
    
    /**
     * Test the output of the get(k) behavior
     */ 
    @Test
    public void testGet() {
    	assertTrue(tree.isEmpty());
        tree.put(2, "two");
        assertEquals(1, tree.size());
        assertEquals("two", tree.get(2));
        tree.put(1, "one");
        assertEquals("two", tree.get(2));
        assertEquals("one", tree.get(1)); 
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
    	tree.put(2, "two");
    	tree.put(1, "one");
    	tree.put(5, "five");
    	tree.put(6, "six");
    	tree.put(7, "seven");
    	tree.put(4, "four");
    	assertEquals(6, tree.size());
        assertEquals(4, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(5, (int)tree.left(tree.right(tree.root())).getElement().getKey());   
        
        assertEquals("four", tree.remove(4));
        assertEquals(5, tree.size());
        assertEquals(6, (int)tree.root().getElement().getKey());
        assertEquals(7, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(5, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(2, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.left(tree.left(tree.root()))).getElement().getKey());
       // assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
      //  assertEquals(5, (int)tree.left(tree.right(tree.root())).getElement().getKey()); 
 
        
    	
    	
                
    }
}