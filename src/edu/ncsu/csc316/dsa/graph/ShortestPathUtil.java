package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.priority_queue.AdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.HeapAdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.set.HashSet;
import edu.ncsu.csc316.dsa.set.Set;

/**
 * ShortestPathUtil provides a collection of behaviors for computing shortest
 * path spanning trees for a given graph.
 * 
 * The ShortestPathUtil class is based on the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 *
 */
public class ShortestPathUtil {
    
    /**
     * For a connected graph, returns a map that represents shortest path costs to
     * all vertices computed using Dijkstra's single-source shortest path algorithm.
     * 
     * @param <V>   the type of data in the graph vertices
     * @param <E>   the type of data in the graph edges
     * @param graph the graph for which to compute the shortest path spanning tree
     * @param start the vertex at which to start computing the shortest path spanning tree    
     * @return a map that represents the shortest path costs to all vertices in the graph  
     */ 
    public static <V, E extends Weighted> Map<Vertex<V>, Integer> dijkstra(Graph<V, E> graph, Vertex<V> start) {
    	AdaptablePriorityQueue<Integer, Vertex<V>> sVertex = new HeapAdaptablePriorityQueue<Integer, Vertex<V>>();
    	Map<Vertex<V>, Integer> currentCosts = new LinearProbingHashMap<Vertex<V>, Integer>();
    	Set<Vertex<V>> fVertex = new HashSet<Vertex<V>>();
    	Map<Vertex<V>, AdaptablePriorityQueue.Entry<Integer, Vertex<V>>> associatedEntry = new LinearProbingHashMap<Vertex<V>, AdaptablePriorityQueue.Entry<Integer, Vertex<V>>>();
    	
    	for (Vertex<V> v : graph.vertices()) {
    		if (v.equals(start)) {
    			currentCosts.put(v, 0);
    		} else {
    			currentCosts.put(v, Integer.MAX_VALUE);
    		}
    		int currentCost = currentCosts.get(v);
    		AdaptablePriorityQueue.Entry<Integer, Vertex<V>> entry = sVertex.insert(currentCost, v);
    		associatedEntry.put(v, entry);
    	}
    	while(!sVertex.isEmpty()) {
			AdaptablePriorityQueue.Entry<Integer, Vertex<V>> entry = sVertex.deleteMin();
            Vertex<V> u = entry.getValue();
            fVertex.add(u);
            
            for (Edge<E> e : graph.outgoingEdges(u)) {
            	Vertex<V> z = graph.opposite(u, e);
            	if (!fVertex.contains(z)) {
                    int newCost = e.getElement().getWeight() + currentCosts.get(u);

                    if (newCost < currentCosts.get(z)) {
                    	currentCosts.put(z, newCost);
                        sVertex.replaceKey(associatedEntry.get(z), newCost);
                    }
                }
            }
            	
		}
    	return currentCosts;
    	
    }
    
    /**
     * For a connected graph, returns a map that represents shortest path spanning
     * tree edges computed using Dijkstra's single-source shortest path algorithm.
     * @param <V> the type of data in the graph vertices
     * @param <E> the type of data in the graph edges
     * @param graph the graph for which to compute the shortest path spanning tree     
     * @param start the vertex at which to start computing the shortest path spanning tree               
     * @param costs the map of shortest path costs to reach each vertex in the graph          
     * @return a map that represents the shortest path spanning tree edges
     */ 
    public static <V, E extends Weighted> Map<Vertex<V>, Edge<E>> shortestPathTree(Graph<V, E> graph, Vertex<V> start, Map<Vertex<V>, Integer> costs) {
    	Map<Vertex<V>, Edge<E>> edges = new LinearProbingHashMap<>();
    	for (Vertex<V> v : costs) {
            if (!v.equals(start)) {
                for (Edge<E> e : graph.incomingEdges(v)) {
                    Vertex<V> u = graph.opposite(v, e);

                    if (costs.get(v) == costs.get(u) + e.getElement().getWeight()) {
                    	edges.put(v, e);
                    }
                }
            }
        }

        return edges;
    }
}