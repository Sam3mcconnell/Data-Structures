package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * RadixSorter uses the radix sort algorithm to sort data
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {

	/**
	 * This method uses the radix sort algorithm to sort an array
	 * @param data as the array that needs to be sorted.
	 */
	@Override
	public void sort(E[] data) {
		int k = 0;
		for (int i = 0; i < data.length; i++) {
			k = Math.max(k, data[i].getId());
		}
		int x = (int) Math.ceil(Math.log10(k + 1));
		
		int p = 1;
		for (int j = 1; j <= x; j++) {
			int[] range = new int[10];
			for (int i = 0; i < data.length; i++) {
				range[(data[i].getId() / p) % 10] = range[(data[i].getId() / p) % 10] + 1;
			}
			for (int i = 1; i <= 9; i++) {
				range[i] = range[i - 1] + range[i];
			}
			
			@SuppressWarnings("unchecked")
			E[] sorted = (E[])(new Identifiable[data.length]);
			for (int i = data.length - 1; i >= 0; i--) {
				sorted[ range[ (data[i].getId() / p) % 10] - 1] = data[i];
				range[ (data[i].getId() / p) % 10] = range[ (data[i].getId() / p) % 10] - 1;
			}
			
			for (int i = 0; i < data.length; i++) {
				data[i] = sorted[i];
			}
			p = p * 10;
		}
		
	}
	
}
