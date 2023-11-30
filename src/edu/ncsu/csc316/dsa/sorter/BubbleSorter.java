package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * BubbleSorter uses the bubble sort algorithm to sort data
 * @author Sam McConnell
 *
 * @param <E> the generic type of data to sort
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructs the bubblesorter with a comparator.
	 * @param comparator as the student object.
	 */
	public BubbleSorter(Comparator<E> comparator) {
		super(comparator);
	}
	
	/**
	 * Constructs the bubblesorter without a comparator.
	 */
	public BubbleSorter() {
		super(null);
	}

	/**
	 * This method uses the bubble sort algorithm to sort an array
	 * @param data as the array that needs to be sorted.
	 */
	@Override
	public void sort(E[] data) {
		boolean r = true;
		while (r) {
			r = false;
			for (int i = 1; i < data.length; i++) {
				if (super.compare(data[i], data[i - 1]) < 0) {
					E x = data[i - 1];
					data[i - 1] = data[i];
					data[i]  = x;
					r = true;
				}
			}
		}
		
	}

}
