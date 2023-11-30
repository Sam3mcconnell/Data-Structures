package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 * @author Dr. King
 * 
 * @param <E> the generic type of data to sort
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructs the InsertionSorter with a comparator.
	 * @param comparator as the student object.
	 */
    public InsertionSorter(Comparator<E> comparator) {
        super(comparator);
    }
    
	/**
	 * Constructs the InsertionSorter without a comparator.
	 */
    public InsertionSorter() {
        super(null);
    }

    /**
	 * This method uses the insertion sort algorithm to sort an array
	 * @param data as the array that needs to be sorted.
	 */
    public void sort(E[] data) {
    	for (int i = 1; i < data.length; i++) {
    		E x = data[i];
    		int j = i - 1;
    		while (j >= 0 && super.compare(data[j], x) > 0) {
    			data[j + 1] = data[j];
    			j = j - 1;
    		}
    		data[j + 1] = x;
    	}
    }
}



