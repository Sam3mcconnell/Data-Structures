package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/**
 * The Positional Linked List is implemented as a doubly-linked list data
 * structure to support efficient, O(1) worst-case Positional List abstract data
 * type behaviors.
 * 
 * Size is maintained as a global field to ensure O(1) worst-case runtime of
 * size() and isEmpty().
 * 
 * The PositionalLinkedList class is based on the implementation developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley & Sons, 2014
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the positional list
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

    /** A dummy/sentinel node representing at the front of the list **/
    private PositionalNode<E> front;

    /** A dummy/sentinel node representing at the end/tail of the list **/
    private PositionalNode<E> tail;

    /** The number of elements in the list **/
    private int size;

    /**
     * Constructs an empty positional linked list
     */
    public PositionalLinkedList() {
        front = new PositionalNode<E>(null);
        tail = new PositionalNode<E>(null, null, front);
        front.setNext(tail);
        size = 0;
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
	 * Adds after a passed position
	 * @param p the position to add after
	 * @param element the element being added
	 * @return the node that was added.
	 */
	@Override
	public Position<E> addAfter(Position<E> p, E element) {
		PositionalNode<E> node = validate(p);
		return addBetween(element, node.getNext(), node);
	}

	/**
	 * Adds before a passed position
	 * @param p the position to add before
	 * @param element the element being added
	 * @return the node that was added.
	 */
	@Override
	public Position<E> addBefore(Position<E> p, E element) {
		PositionalNode<E> node = validate(p);
		return addBetween(element, node, node.getPrevious());
	}

	/**
	 * Adds an element to the front of the list
	 * @param element the element being added
	 * @return the node that was added.
	 */
	@Override
	public Position<E> addFirst(E element) {
		return addBetween(element, front.getNext(), front);
	}

	/**
	 * Adds an element to the back of the list
	 * @param element the element being added
	 * @return the node that was added.
	 */
	@Override
	public Position<E> addLast(E element) {
		return addBetween(element, tail, tail.getPrevious());
	}
	
	/**
	 * A private helper method that adds an element between two other position.
	 * @param element as the element being added
	 * @param next as the next element of the element being added
	 * @param prev as the previous element of the element being added
	 * @return the node of the element
	 */
	private Position<E> addBetween(E element, PositionalNode<E> next, PositionalNode<E> prev) {
		PositionalNode<E> newNode = new PositionalNode<>(element, next, prev);
		prev.setNext(newNode);
		next.setPrevious(newNode);
		size++;
		return newNode;
	}

	/**
	 * Gets the element after the position
	 * @param p the position of the element that you want to get the element after from.
	 * @return the node of the element after
	 */
	@Override
	public Position<E> after(Position<E> p) {
		PositionalNode<E> node = validate(p);
        if (node.getNext() == tail) {
            return null;
        }
        return node.getNext();
	}

	/**
	 * Gets the element before the position
	 * @param p the position of the element that you want to get the element before from.
	 * @return the node of the element before
	 */
	@Override
	public Position<E> before(Position<E> p) {
		PositionalNode<E> node = validate(p);
		if(node.getPrevious() == front) {
			return null;
		}
        return node.getPrevious();
	}

	/**
	 * Gets the first element
	 * @return the first element
	 */
	@Override
	public Position<E> first() {
		if (isEmpty()) {
            return null;
        }
        return front.getNext();
	}

	/**
	 * Checks if the list is empty
	 * @return if the element is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Gets the last element
	 * @return the last element
	 */
	@Override
	public Position<E> last() {
		if (isEmpty()) {
            return null;
        }
        return tail.getPrevious();
	}

	/**
	 * Creates a new position Iterable
	 * @return a position Iterable
	 */
	@Override
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	/**
	 * Removes an element at a position
	 * @param p the position of the element that is being removed
	 * @return the element that was romoved.
	 */
	@Override
	public E remove(Position<E> p) {
		PositionalNode<E> node = validate(p);
        E old = node.getElement();
        node.previous.next = node.getNext();
        node.next.previous = node.previous;
        size--;
        return old;
	}

	/**
	 * Sets an element at specific position
	 * @param p as the postion of the element that is being set
	 * @param element as the new element
	 * @return the element that was set
	 */
	@Override
	public E set(Position<E> p, E element) {
		PositionalNode<E> node = validate(p);
	    E old = node.getElement();
	    node.setElement(element);
	    return old;
	}

	/**
	 * Gets the size of the list
	 * @return the size of the list
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
     * Safely casts a Position, p, to be a PositionalNode.
     * 
     * @param p the position to cast to a PositionalNode
     * @return a reference to the PositionalNode
     * @throws IllegalArgumentException if p is null, or if p is not a valid
     *                                  PositionalNode
     */
    private PositionalNode<E> validate(Position<E> p) {
        if (p instanceof PositionalNode) {
            return (PositionalNode<E>) p;
        }
        throw new IllegalArgumentException("Position is not a valid positional list node.");
    }

    /**
     * Inner class that creates the nodes of the list
     * @author semcconn
     *
     * @param <E> as the object of the node
     */
	private static class PositionalNode<E> implements Position<E> {

		/** the element */
        private E element;
        /** The next node */
        private PositionalNode<E> next; 
        /** The previous node */
        private PositionalNode<E> previous;

        /**
         * Constructs a position with just an element
         * @param value as the element
         */
        public PositionalNode(E value) {
            this(value, null);
        }

        /**
         * Constructs a position with an element and a next node
         * @param value as the element
         * @param next as the next node
         */
        public PositionalNode(E value, PositionalNode<E> next) {
            this(value, next, null);
        }

        /**
         * Constructs a position with an element, next, and previous node
         * @param value as the element
         * @param next as the next node
         * @param prev as the previous node
         */
        public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
            setElement(value);
            setNext(next);
            setPrevious(prev);
        }

        /**
         * Sets the previous node
         * @param prev as the previous node
         */
        public void setPrevious(PositionalNode<E> prev) {
            previous = prev;
        }

        /**
         * Gets the previous node
         * @return the previous node
         */
        public PositionalNode<E> getPrevious() {
            return previous;
        }
        
        /**
         * Sets the next node
         * @param next as the next node
         */
        public void setNext(PositionalNode<E> next) {
            this.next = next;
        }

        /**
         * Gets the next node
         * @return the next node
         */
        public PositionalNode<E> getNext() {
            return next;
        }

        /**
         * Gets the element
         * @return the element
         */
        @Override
        public E getElement() {
            return element;
        }
        
        /**
         * Sets the element
         * @param element as the element
         */
        public void setElement(E element) {
            this.element = element;
        }
        
    }  
	
	/**
	 * Inner private class to iterate through the positions
	 * @author semcconn
	 *
	 */
	private class PositionIterator implements Iterator<Position<E>> {

		/** The current position */
		private Position<E> current;
		/** If it is ok to remove a postion */
	    private boolean removeOK;

	    /**
	     * Construct a new element iterator where the cursor is initialized 
	     * to the beginning of the list.
	     */
	    public PositionIterator() {
	    	current = front;
	        removeOK = false;
	    }

	    /**
	     * Checks if the list has a next element
	     * @return true if it does.
	     */
	    @Override
	    public boolean hasNext() {
	        return validate(current).next.getElement() != null;
	    }

	    /**
	     * Returns the next element in the list and iterates
	     * @return the next element in the list
	     */
	    @Override
	    public Position<E> next() {
	    	if (hasNext()) {
	            current = after(current);
	            removeOK = true;
	            return current;
	        } else {
	          	throw new NoSuchElementException();
	        }
	    }

	    /**
	     * Removes the element that was last returned by next.
	     */
	    @Override
	    public void remove() {
	    	if (removeOK) {
	    		PositionalLinkedList.this.remove(current);
	            removeOK = false;
	    	} else {
	          	throw new IllegalStateException();
	        }
	    }
	}
	 
	/**
	 * Inner private class to iterate through the elements
	 * @author semcconn
	 *
	 */
	private class ElementIterator implements Iterator<E> {

		/** The current position */
		private Iterator<Position<E>> it;

		/**
	     * Construct a new element iterator where the cursor is initialized 
	     * to the beginning of the list.
	     */
	    public ElementIterator() {
	    	it = new PositionIterator();
	    }

	    /**
	     * Checks if the list has a next element
	     * @return true if it does.
	     */
	    @Override
	    public boolean hasNext() {
	    	return it.hasNext();
	    }

	    /**
	     * Returns the next element in the list and iterates
	     * @return the next element in the list
	     */
	    @Override
	    public E next() {
	    	return it.next().getElement();
	    }

	    /**
	     * Removes the element that was last returned by next.
	     */
	    @Override
	    public void remove() {
	    	it.remove();
	    }
	}
	
	/**
	 * Inner class to construct a new position iterable
	 * @author semcconn
	 *
	 */
	private class PositionIterable implements Iterable<Position<E>> {
        
		/**
		 * Constructs the position iterable
		 * @return the new PositionIterator
		 */
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

}