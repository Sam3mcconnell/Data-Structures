package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for AVLTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an AVL tree data structure 
 *
 * @author Dr. King
 *
 */
public class AVLTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of an AVL tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new AVLTreeMap<Integer, String>(); 
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
        assertEquals(1, (int)tree.left(tree.root()).getElement().getKey());
        
        tree.put(5, "five");
        assertEquals(3, tree.size());
        assertEquals(5, (int)tree.right(tree.root()).getElement().getKey());
        
        tree.put(6, "six");
        assertEquals(4, tree.size());
        assertEquals(6, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(7, "seven");
        assertEquals(5, tree.size());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        
        assertEquals(5, (int)tree.left(tree.right(tree.root())).getElement().getKey());
        
        tree.put(4, "four");
        assertEquals(6, tree.size());
        assertEquals(5, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int)tree.right(tree.left(tree.root())).getElement().getKey());
        
        tree.put(0, "zero");
        assertEquals(5, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int)tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, (int)tree.left(tree.left(tree.left(tree.root()))).getElement().getKey());
        
        tree.put(-1, "negativeOne");
        assertEquals(5, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(0, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int)tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(-1, (int)tree.left(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(1, (int)tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
 
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
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        tree.put(2, "two");
        tree.put(1, "one");
        tree.put(5, "five"); 
        tree.put(6, "six");
        tree.put(7, "seven");
        tree.put(4, "four");
        tree.put(0, "zero"); 
        tree.put(-1, "negativeOne"); 
        assertEquals(5, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(0, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int)tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(-1, (int)tree.left(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(1, (int)tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        
        assertEquals("five", tree.remove(5));
        assertEquals(2, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(0, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(-1, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(1, (int)tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int)tree.left(tree.right(tree.root())).getElement().getKey());
        
        assertEquals("zero", tree.remove(0));
        assertEquals(2, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(-1, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int)tree.left(tree.right(tree.root())).getElement().getKey());
        
        assertEquals("negativeOne", tree.remove(-1));
        assertEquals(2, (int)tree.root().getElement().getKey());
        assertEquals(6, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(4, (int)tree.left(tree.right(tree.root())).getElement().getKey());
        
        assertEquals("six", tree.remove(6));
        assertEquals(2, (int)tree.root().getElement().getKey());
        assertEquals(7, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(4, (int)tree.left(tree.right(tree.root())).getElement().getKey());
             
    }
}