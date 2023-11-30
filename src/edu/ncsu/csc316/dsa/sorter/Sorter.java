package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior
 * @author Dr. King
 * @param <E> the generic type of data to sort
 */
public interface Sorter<E> {
	
	/**
	 * This is the sort method all child classes will use
	 * @param data as the array.
	 */
	public void sort(E[] data);
}
