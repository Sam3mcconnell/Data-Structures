package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly-linked list is a linked-memory representation of the List abstract
 * data type. This list maintains a dummy/sentinel front node in the list to
 * help promote cleaner implementations of the list behaviors. This list also
 * maintains a reference to the tail/last node in the list at all times to
 * ensure O(1) worst-case cost for adding to the end of the list. Size is
 * maintained as a global field to allow for O(1) size() and isEmpty()
 * behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

    /** A reference to the dummy/sentinel node at the front of the list **/
    private LinkedListNode<E> front;
    
    /** A reference to the last/final node in the list **/
    private LinkedListNode<E> tail;
    
    /** The number of elements stored in the list **/
    private int size;
        
    /**
     * Constructs an empty singly-linked list
     */     
    public SinglyLinkedList() {
        // Let front be a dummy (sentinel) node
        front = new LinkedListNode<E>(null); 
        tail = null;
        size = 0;
    }

    /**
     * Adds an element at a specific index
     * @param index as the index of the element being added
     * @param element as the element being added.
     */
	@Override
	public void add(int index, E element) {
		checkIndexForAdd(index);
		
		LinkedListNode<E> newNode = new LinkedListNode<E>(element);
		
		if (index == 0) {
			newNode.next = front.next;
			front.next = newNode;
			if (size == 0) {
				tail = newNode;
			}
		} else if(index == size) {
			tail.next = newNode;
			tail = newNode;
		} else {
			LinkedListNode<E> current = front.next;
	        for (int i = 0; i < index - 1; i++) {
	            current = current.next;
	        }
	        newNode.next = current.next;
	        current.next = newNode;
		}
		size++;
		
	}

	/**
	 * Gets an element at a specific index 
	 * @param index of element to be returned
	 * @return the element at the index
	 */
	@Override
	public E get(int index) {
		checkIndex(index);
		LinkedListNode<E> current = front.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Removes an element at a specific index 
	 * @param index of element to be removed
	 * @return the element at the index that was removed
	 */
	@Override
	public E remove(int index) {
		checkIndex(index);
		E old;
		if (index == 0) {
			old = front.next.data;
			front.next = front.next.next;
			if (size == 1) {
				tail = null;
			}
		} else {
			LinkedListNode<E> current = front.next;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			old = current.next.data;
			current.next = current.next.next;
			if (index == size - 1) {
				tail = current;
			}
		}
		size--;
		
		return old;
	}

	/**
	 * Sets an element at a specific index 
	 * @param index of element to be set
	 * @param element as the element that will be replacing the old
	 * @return the element at the index that was replaced
	 */
	@Override
	public E set(int index, E element) {
		checkIndex(index);
		LinkedListNode<E> current = front.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		E old = current.data;
		current.data = element;
		return old;
	}

	@Override
	public int size() {
		return size;
	}
	
	/**
     * {@inheritDoc} For a singly-linked list, this behavior has O(1) worst-case
     * runtime.
     */
    @Override
    public E last() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return tail.data;
    }

    /**
     * {@inheritDoc}
     * For this singly-linked list, addLast(element) behavior has O(1) worst-case runtime.
     */    
    @Override
    public void addLast(E element) {
    	LinkedListNode<E> newNode = new LinkedListNode<E>(element);
    	if (isEmpty()) {
            front.next = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**
	 * Returns a new iterator to iterate through the list
	 * @return the new iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
    /**
     * Private inner class for a list node
     * @author semcconn
     *
     * @param <E> as the object of the node
     */
	private static class LinkedListNode<E> {
		
        /** the data of the node */
        private E data;
        /** The next node */
        private LinkedListNode<E> next;
        
        /**
         * Constructs a node without a next
         * @param data as the data of the node
         */
        private LinkedListNode(E data) {
        	this(data, null);
        }
        
        /**
         * Constructs a node with a next
         * @param data as the data of the node
         * @param next as the next node
         */
        private LinkedListNode(E data, LinkedListNode<E> next) {
        	this.data = data;
        	this.next = next; 
        }
    }
	
	private class ElementIterator implements Iterator<E> {
	    /**
	     * Keep track of the next node that will be processed
	     */
	    private LinkedListNode<E> current;
	    
	    
	    /**
	     * Construct a new element iterator where the cursor is initialized 
	     * to the beginning of the list.
	     */
	    public ElementIterator() { 
	        current = front.next;
	    }
	    
	    /**
	     * Checks if the list has a next element
	     * @return true if it does.
	     */
	    @Override
	    public boolean hasNext() {
	    	return (current != null);
	    }
	    
	    /**
	     * Returns the next element in the list and iterates
	     * @return the next element in the list
	     */
	    @Override
	    public E next() {
	    	if (!hasNext()) {
	    		throw new NoSuchElementException();
	    	} 
	    	E next = current.data;
    		current = current.next;
    		return next;
	    	
	    }
	    /**
	     * Does nothing
	     */
	    @Override    
	    public void remove() {
		    // DO NOT CHANGE THIS METHOD
	        throw new UnsupportedOperationException(
	            "This SinglyLinkedList implementation does not currently support removal of elements when using the iterator.");
	    }
	}
    
}
