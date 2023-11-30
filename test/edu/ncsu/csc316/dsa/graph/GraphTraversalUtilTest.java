package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*; 

import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for GraphTraversalUtil
 * Checks the expected outputs of depth first search
 * and breadth first search
 *
 * @author Dr. King
 *
 */
public class GraphTraversalUtilTest {

    /**
     * Test the output of depth first search on a graph
     */ 
    @Test
    public void testDepthFirstSearch() {
    	Graph<Integer, String> graph = new AdjacencyListGraph<>();
        Vertex<Integer> one = graph.insertVertex(1);
        Vertex<Integer> two = graph.insertVertex(2);
        Vertex<Integer> three = graph.insertVertex(3);
        Vertex<Integer> four = graph.insertVertex(4);
        Edge<String> e12 = graph.insertEdge(one, two, "12");
        Edge<String> e13 = graph.insertEdge(one, three, "13");
        Edge<String> e24 = graph.insertEdge(two, four, "24");
        
        Map<Vertex<Integer>, Edge<String>> dfsResult = GraphTraversalUtil.depthFirstSearch(graph, one);
        assertEquals(null, dfsResult.get(one));
        assertEquals(e12, dfsResult.get(two));
        assertEquals(e13, dfsResult.get(three));
        assertEquals(e24, dfsResult.get(four));
    }
    
    /**
     * Test the output of the breadth first search
     */ 
    @Test
    public void testBreadthFirstSearch() {
    	Graph<Integer, String> graph = new AdjacencyListGraph<>();
        Vertex<Integer> one = graph.insertVertex(1);
        Vertex<Integer> two = graph.insertVertex(2);
        Vertex<Integer> three = graph.insertVertex(3);
        Vertex<Integer> four = graph.insertVertex(4);

        Edge<String> e12 = graph.insertEdge(one, two, "12");
        Edge<String> e13 = graph.insertEdge(one, three, "13");
        Edge<String> e24 = graph.insertEdge(two, four, "24");

        Map<Vertex<Integer>, Edge<String>> bfsResult = GraphTraversalUtil.breadthFirstSearch(graph, one);

        assertEquals(null, bfsResult.get(one));
        assertEquals(e12, bfsResult.get(two));
        assertEquals(e13, bfsResult.get(three));
        assertEquals(e24, bfsResult.get(four));
    }
    
}