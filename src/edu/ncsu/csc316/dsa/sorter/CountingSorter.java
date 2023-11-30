package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * CountingSorter uses the counting sort algorithm to sort data
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class CountingSorter<E extends Identifiable> implements Sorter<E> {
    
	/**
	 * This method uses the counting sort algorithm to sort an array
	 * @param data as the array that needs to be sorted.
	 */
    public void sort(E[] data) {
    	int min = data[0].getId();
    	int max = data[0].getId();
    	for (int i = 0; i < data.length; i++) {
    		min = Math.min(data[i].getId(), min);
    		max = Math.max(data[i].getId(), max);
    	}
    	int k = (max - min + 1);
    	int[] range = new int[k];
    	for (int i = 0; i < data.length; i++) {
    		range[data[i].getId() - min] = range[data[i].getId() - min] + 1;
    	}
    	for (int i = 1; i < k; i++) {
    		range[i] = range[i - 1] + range[i];
    	}
    	
    	@SuppressWarnings("unchecked")
		E[] sorted = (E[])(new Identifiable[data.length]);
    	for (int i = data.length - 1; i >= 0; i--) {
    		sorted[range[data[i].getId() - min] - 1] = data[i];
    		range[data[i].getId() - min] = range[data[i].getId() - min] - 1;
    	}
    	
    	for (int i = 0; i < data.length; i++) {
    		data[i] = sorted[i];
    	}
    }
}
