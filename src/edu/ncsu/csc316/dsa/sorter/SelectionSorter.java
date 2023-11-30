package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
    
	/**
	 * Constructs the SelectionSorter with a comparator.
	 * @param comparator as the student object.
	 */
    public SelectionSorter(Comparator<E> comparator) {
        super(comparator);
    }
    
    /**
	 * Constructs the SelectionSorter without a comparator.
	 */
    public SelectionSorter() {
    	super(null);
    }
    
    /**
	 * This method uses the bubble sort algorithm to sort an array
	 * @param data as the array that needs to be sorted.
	 */
    public void sort(E[] data) {
    	for (int i = 0; i < data.length; i++) {
    		int min = i; 
    		for (int j = i + 1; j < data.length; j++) {
    			if (super.compare(data[j], data[min]) < 0) {
    				min = j;
    			}
    		}
    		if (i != min) {
    			E x = data[i];
    			data[i] = data[min];
    			data[min] = x;
    		}
    	}
    }
}



