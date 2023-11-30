package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * Test class for MinimumSpanningTreeUtil
 * Checks the expected outputs of Prim-Jarnik's algorithm
 * and Kruskal's algorithm
 *
 * @author Dr. King
 *
 */
public class MinimumSpanningTreeUtilTest {

    /**
     * Test the output of Prim-Jarnik's algorithm
     */ 
    @Test
    public void testPrimJarnik() {
    	 Graph<Integer, Highway> graph = new AdjacencyListGraph<>();

         Vertex<Integer> one = graph.insertVertex(1);
         Vertex<Integer> two = graph.insertVertex(2);
         Vertex<Integer> three = graph.insertVertex(3);
         Vertex<Integer> four = graph.insertVertex(4);

         Edge<Highway> e12 = graph.insertEdge(one, two, new Highway("77", 2));
         graph.insertEdge(one, three, new Highway("81", 4));
         graph.insertEdge(two, four, new Highway("32", 1));
         Edge<Highway> e15 = graph.insertEdge(three, four, new Highway("41", 2));


         PositionalList<Edge<Highway>> mst = MinimumSpanningTreeUtil.primJarnik(graph);

         assertEquals(e12, mst.first().getElement());
         assertEquals(e15, mst.last().getElement()); 
    }
    
    /**
     * Test the output of Kruskal's algorithm
     */ 
    @Test
    public void testKruskal() {
    	Graph<Integer, Highway> graph = new AdjacencyListGraph<>();

        Vertex<Integer> one = graph.insertVertex(1);
        Vertex<Integer> two = graph.insertVertex(2);
        Vertex<Integer> three = graph.insertVertex(3); 
        Vertex<Integer> four = graph.insertVertex(4);
        Vertex<Integer> five = graph.insertVertex(5);

        graph.insertEdge(one, two, new Highway("77", 2));
        graph.insertEdge(one, three, new Highway("81", 4));
        Edge<Highway> e24 = graph.insertEdge(two, four, new Highway("32", 1));
        Edge<Highway> e35 = graph.insertEdge(three, five, new Highway("41", 3));
        graph.insertEdge(four, five, new Highway("1", 2));

        PositionalList<Edge<Highway>> mst = MinimumSpanningTreeUtil.kruskal(graph);
        assertEquals(e24, mst.first().getElement());
        assertEquals(e35, mst.last().getElement());
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