package edu.ncsu.csc316.dsa.tree;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for LinkedBinaryTree
 * Checks the expected outputs of the BinaryTree abstract data type behaviors when using
 * a linked data structure to store elements
 *
 * @author Dr. King
 *
 */
public class LinkedBinaryTreeTest {

    private LinkedBinaryTree<String> tree;
    private Position<String> one;
    private Position<String> two;
    private Position<String> three;
    private Position<String> four;
    private Position<String> five;
    private Position<String> six;
    private Position<String> seven;
    private Position<String> eight;
    private Position<String> nine;
    private Position<String> ten;

    /**
     * Create a new instance of a linked binary tree before each test case executes
     */       
    @Before
    public void setUp() {
        tree = new LinkedBinaryTree<String>(); 
    }
    
    /**
     * Sample tree to help with testing
     *
     * One
     * -> Two
     *   -> Six
     *   -> Ten
     *     -> Seven
     *     -> Five
     * -> Three
     *   -> Four
     *     -> Eight
     *     -> Nine
     * 
     * Or, visually:
     *                    one
     *                /        \
     *             two          three
     *            /   \            /
     *         six   ten          four
     *              /   \        /     \
     *            seven  five  eight nine    
     */  
    private void createTree() {
        one = tree.addRoot("one");
        two = tree.addLeft(one, "two");
        three = tree.addRight(one, "three");
        six = tree.addLeft(two, "six");
        ten = tree.addRight(two, "ten");
        four = tree.addLeft(three, "four");
        seven = tree.addLeft(ten, "seven");
        five = tree.addRight(ten, "five");
        eight = tree.addLeft(four, "eight");
        nine = tree.addRight(four, "nine");
    }
    
    /**
     * Test the output of the set(p,e) behavior
     */     
    @Test
    public void testSet() {
        createTree();
        assertEquals("three", tree.set(three, "eleven"));
        assertEquals("eleven", tree.right(one).getElement());
    }
    
    /**
     * Test the output of the size() behavior
     */     
    @Test
    public void testSize() {
        assertTrue(tree.isEmpty());
        createTree();
        assertEquals(10, tree.size());
    }
    
    /**
     * Test the output of the numChildren(p) behavior
     */     
    @Test
    public void testNumChildren() {
        createTree();
        assertEquals(2, tree.numChildren(two));
        assertEquals(1, tree.numChildren(three));
        assertEquals(0, tree.numChildren(eight));
    }

    /**
     * Test the output of the parent(p) behavior
     */   
    @Test
    public void testParent() {
        createTree();
        assertEquals(three, tree.parent(four));
        assertEquals(null, tree.parent(one));
    }

    /**
     * Test the output of the sibling behavior
     */     
    @Test
    public void testSibling() {
        createTree();
        assertEquals(nine, tree.sibling(eight));
        assertEquals(null, tree.sibling(four));
    }

    /**
     * Test the output of the isInternal behavior
     */     
    @Test
    public void testIsInternal() {
        createTree();
        assertTrue(tree.isInternal(two)); 
        assertFalse(tree.isInternal(five));
    }

    /**
     * Test the output of the isLeaf behavior
     */     
    @Test
    public void isLeaf() {
        createTree();
        assertFalse(tree.isLeaf(two)); 
        assertTrue(tree.isLeaf(five));
    }

    /**
     * Test the output of the isRoot(p)
     */     
    @Test
    public void isRoot() {
        createTree();
        assertFalse(tree.isRoot(ten)); 
        assertTrue(tree.isRoot(one));
    }
    
    
    /**
     * Test the output of the preOrder traversal behavior
     */     
    @Test
    public void testPreOrder() {
        createTree();
        Iterable<Position<String>> it = tree.preOrder();
        Iterator<Position<String>> io = it.iterator();
        assertEquals(one, io.next());
        assertEquals(two, io.next());
        assertEquals(six, io.next());
        assertEquals(ten, io.next());
        assertEquals(seven, io.next());
        assertEquals(five, io.next());
        assertEquals(three, io.next());
        assertEquals(four, io.next());
        assertEquals(eight, io.next());
        assertEquals(nine, io.next());
        
    }
     

    /**
     * Test the output of the postOrder traversal behavior
     */     
    @Test
    public void testPostOrder() {
    	// Should be six, seven, five, ten, two, eight, nine, four, three, one
    	createTree();
        Iterable<Position<String>> it = tree.postOrder();
        Iterator<Position<String>> io = it.iterator();
        assertEquals("six", io.next().getElement());
        assertEquals("seven", io.next().getElement());
        assertEquals("five", io.next().getElement());
        assertEquals("ten", io.next().getElement());
        assertEquals("two", io.next().getElement());
        assertEquals("eight", io.next().getElement());
        assertEquals("nine", io.next().getElement());
        assertEquals("four", io.next().getElement());
        assertEquals("three", io.next().getElement());
        assertEquals("one", io.next().getElement());
    }
    
    /**
     * Sample tree to help with testing
     *
     * One
     * -> Two
     *   -> Six
     *   -> Ten
     *     -> Seven
     *     -> Five
     * -> Three
     *   -> Four
     *     -> Eight
     *     -> Nine
     * 
     * Or, visually:
     *                    one
     *                /        \
     *             two          three
     *            /   \            /
     *         six   ten          four
     *              /   \        /     \
     *            seven  five  eight nine    
     */ 
    
    /**
     * Test the output of the inOrder traversal behavior
     */     
    @Test
    public void testInOrder() {
    	createTree();
        Iterable<Position<String>> it = tree.inOrder();
        Iterator<Position<String>> io = it.iterator();
        assertEquals("six", io.next().getElement());
        assertEquals("two", io.next().getElement());
        assertEquals("seven", io.next().getElement());
        assertEquals("ten", io.next().getElement());
        assertEquals("five", io.next().getElement());
        assertEquals("one", io.next().getElement());
        assertEquals("eight", io.next().getElement());
        assertEquals("four", io.next().getElement());
        assertEquals("nine", io.next().getElement());
        assertEquals("three", io.next().getElement());
    }

    /**
     * Test the output of the Binary Tree ADT behaviors on an empty tree
     */     
    @Test
    public void testEmptyTree() {
        assertTrue(tree.isEmpty());
        createTree();
        assertFalse(tree.isEmpty());
        
        
    }
    
   
    
    @Test
    public void testLevelOrder() {
        createTree();
        Iterable<Position<String>> it = tree.levelOrder();
        Iterator<Position<String>> io = it.iterator();
        assertEquals("one", io.next().getElement());
        assertEquals("two", io.next().getElement());
        assertEquals("three", io.next().getElement());
        assertEquals("six", io.next().getElement());
        assertEquals("ten", io.next().getElement());
        assertEquals("four", io.next().getElement());
        assertEquals("seven", io.next().getElement());
        assertEquals("five", io.next().getElement());
        assertEquals("eight", io.next().getElement());
        assertEquals("nine", io.next().getElement());
        
    }


    /**
     * Test the output of the remove(p) behavior, including expected exceptions
     */         
    @Test
    public void testRemove() {
        createTree();
        assertEquals("eight", tree.remove(eight));
        assertEquals(null, tree.left(four));
        assertEquals("nine", tree.remove(nine));
        assertEquals(0, tree.numChildren(four));
        assertEquals(2, tree.numChildren(ten));
        assertEquals("seven", tree.remove(seven));
        assertEquals(1, tree.numChildren(ten));
        assertEquals("ten", tree.remove(ten));
        assertEquals(2, tree.numChildren(two));
        assertEquals(five, tree.right(two));
        assertEquals(six, tree.left(two));
        assertEquals(three, tree.right(one));
        assertEquals("three", tree.remove(three));
        assertEquals(four, tree.right(one)); 
    }
    
    /**
     * Test the output of the toString behavior
     */ 
    @Test
    public void testToString() {
    	createTree();
    	String string = "LinkedBinaryTree[\none\n two\n  six\n  ten\n   seven\n   five\n three\n  four\n   eight\n   nine\n]";
    	assertEquals(string, tree.toString());
    }
    
}