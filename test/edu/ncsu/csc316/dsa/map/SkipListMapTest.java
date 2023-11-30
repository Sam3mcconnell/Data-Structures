package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class SkipListMapTest {
	
	private Map<Integer, String> skipListMap;

	/**
     * Create a new instance of an unordered link-based map before each test case executes
     */     
    @Before
    public void setUp() {
    	skipListMap = new SkipListMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, skipListMap.size());
        assertTrue(skipListMap.isEmpty());
        assertNull(skipListMap.put(3, "string3"));
        assertEquals("SkipListMap[3]", skipListMap.toString());
        assertEquals(1, skipListMap.size()); 

        assertEquals("string3", skipListMap.put(3, "string4"));
        
        assertEquals("SkipListMap[3]", skipListMap.toString());
        assertEquals(1, skipListMap.size());
        
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() { 
        assertTrue(skipListMap.isEmpty()); 
        assertNull(skipListMap.put(3, "string3"));
        assertNull(skipListMap.put(5, "string5"));
        assertNull(skipListMap.put(2, "string2"));
        assertNull(skipListMap.put(4, "string4"));
        assertNull(skipListMap.put(1, "string1"));
        assertFalse(skipListMap.isEmpty());
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", skipListMap.toString());
        assertEquals("string1", skipListMap.get(1));  
        assertEquals("string5", skipListMap.get(5));  
        assertEquals(null, skipListMap.get(7));
 
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(skipListMap.isEmpty());
        assertNull(skipListMap.put(3, "string3"));
        assertNull(skipListMap.put(5, "string5"));
        assertNull(skipListMap.put(2, "string2"));
        assertNull(skipListMap.put(4, "string4"));
        assertNull(skipListMap.put(1, "string1"));
        assertFalse(skipListMap.isEmpty());
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", skipListMap.toString());
        
        assertEquals("string5", skipListMap.remove(5));
        assertEquals("SkipListMap[1, 2, 3, 4]", skipListMap.toString());
        
        assertEquals("string2", skipListMap.remove(2));
        assertEquals("SkipListMap[1, 3, 4]", skipListMap.toString());
        
        assertNull(skipListMap.remove(7));
    }
    
    /**
     * Test the output of the entrySet() behavior, including expected exceptions
     */     
    @Test
    public void testEntrySet() {
        assertNull(skipListMap.put(3, "string3"));
        assertNull(skipListMap.put(5, "string5"));
        assertNull(skipListMap.put(2, "string2"));
        assertNull(skipListMap.put(4, "string4"));
        assertNull(skipListMap.put(1, "string1"));
        
        Iterator<Map.Entry<Integer, String>> it = skipListMap.entrySet().iterator();
        assertTrue(it.hasNext());
        Map.Entry<Integer, String> entry = it.next();
        assertEquals(1, (int)(entry.getKey()));
        assertEquals("string1", (String)(entry.getValue()));

    }

}
