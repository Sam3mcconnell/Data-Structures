package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for ShortestPathUtil
 * Checks the expected outputs of Dijksra's algorithm
 * and the shortest path tree construction method
 *
 * @author Dr. King
 *
 */
public class ShortestPathUtilTest {

    /**
     * Test the output of Dijkstra's algorithm
     */ 
    @Test
    public void testDijkstra() {
    	Graph<Integer, Highway> graph = new AdjacencyListGraph<>();
       
        Vertex<Integer> one = graph.insertVertex(1);
        Vertex<Integer> two = graph.insertVertex(2);
        Vertex<Integer> three = graph.insertVertex(3);
        Vertex<Integer> four = graph.insertVertex(4);
        Vertex<Integer> five = graph.insertVertex(5);
        
        graph.insertEdge(one, two, new Highway("77", 2));
        graph.insertEdge(one, three, new Highway("81", 4));
        graph.insertEdge(two, four, new Highway("32", 1));
        graph.insertEdge(three, five, new Highway("41", 3));
        graph.insertEdge(four, five, new Highway("1", 2));

        Map<Vertex<Integer>, Integer> shortestPaths = ShortestPathUtil.dijkstra(graph, one);
        assertEquals(0, shortestPaths.get(one).intValue());
        assertEquals(2, shortestPaths.get(two).intValue());
        assertEquals(4, shortestPaths.get(three).intValue());
        assertEquals(3, shortestPaths.get(four).intValue());
        assertEquals(5, shortestPaths.get(five).intValue());
    }
    
    /**
     * Test the output of the shortest path tree construction method
     */ 
    @Test
    public void testShortestPathTree() {
Graph<Integer, Highway> graph = new AdjacencyListGraph<>();
        
        Vertex<Integer> one = graph.insertVertex(1);
        Vertex<Integer> two = graph.insertVertex(2);
        Vertex<Integer> three = graph.insertVertex(3);
        Vertex<Integer> four = graph.insertVertex(4);
        Vertex<Integer> five = graph.insertVertex(5);

        Edge<Highway> e12 = graph.insertEdge(one, two, new Highway("77", 2));
        Edge<Highway> e13 = graph.insertEdge(one, three, new Highway("81", 4));
        Edge<Highway> e24 = graph.insertEdge(two, four, new Highway("32", 1));
        Edge<Highway> e45 = graph.insertEdge(four, five, new Highway("1", 2));

        Map<Vertex<Integer>, Integer> shortestPaths = ShortestPathUtil.dijkstra(graph, one);

  
        Map<Vertex<Integer>, Edge<Highway>> shortestPathTree = ShortestPathUtil.shortestPathTree(graph, one, shortestPaths);

        assertEquals(e12, shortestPathTree.get(two));
        assertEquals(e13, shortestPathTree.get(three));
        assertEquals(e24, shortestPathTree.get(four));
        assertEquals(null, shortestPathTree.get(one));
        assertEquals(e45, shortestPathTree.get(five));  
    }
    
    public class Highway implements Weighted {
        private String name;
        private int length;
        
        public Highway(String n, int l) {
            setName(n);
            setLength(l);
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public int getWeight() {
            return getLength();
        }
        
        public String getName() {
        	return name;
        }
    }
    
}