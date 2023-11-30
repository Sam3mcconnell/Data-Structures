package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * This class is an abstract class used to figure out what 
 * value will be compared in the student.
 * @author Sam McConnell
 *
 * @param <E> the generic type of data to sort
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {

	/** as the comparator with type E*/
    private Comparator<E> comparator;
    
    /**
     * Constructs the class
     * @param comparator as the comparator.
     */
    public AbstractComparisonSorter(Comparator<E> comparator) {
        setComparator(comparator);
    }
    
    /**
     * sets the comparator
     * @param comparator as the comparator
     */
    private void setComparator(Comparator<E> comparator) {
        if (comparator == null) {
            this.comparator = new NaturalOrder();
        } else {
            this.comparator = comparator;
        }
    }   
    
    /**
     * Inner class if the comparator is null
     * @author Sam McConnell
     *
     */
    private class NaturalOrder implements Comparator<E> {
        public int compare(E first, E second) {
            return ((Comparable<E>) first).compareTo(second);
        }
    }
    
    /**
     * Compares two objects.
     * @param first as the first object.
     * @param second as the second object.
     * @return the in value of the comparison.
     */
    public int compare(E first, E second) {
        return comparator.compare(first,  second);
    }
}
