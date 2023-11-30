package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;

import edu.ncsu.csc316.dsa.list.SinglyLinkedList;

/**
 * The Linked Stack is implemented as a singly-linked list data structure to
 * support efficient, O(1) worst-case Stack abstract data type behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the stack
 */
public class LinkedStack<E> extends AbstractStack<E> {

    /** Delegate to our existing singly linked list class **/
    private SinglyLinkedList<E> list;

    /**
     * Construct a new singly-linked list to use when modeling the last-in-first-out
     * paradigm for the stack abstract data type.
     */
    public LinkedStack() {
        list = new SinglyLinkedList<E>(); 
    }

    /**
     * Pushes an element onto the top of the stack
     * @param element as the element being pushed to the top of the stack
     */
	@Override
	public void push(E element) {
		list.addFirst(element);
	}

	/**
     * Removes the element on the top of the stack
     * @return the element on the top of the stack that was removed
     */
	@Override
	public E pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return list.removeFirst();
	}

	/**
     * Gets the element on the top of the stack
     * @return the element on the top of the stack
     */
	@Override
	public E top() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return list.first();
	}

	/**
     * Gets the size of the stack
     * @return the size of the stack
     */
	@Override
	public int size() {
		return list.size();
	}
    
}
