package datastructures;

import java.util.LinkedList;

/**
 * Class that offers the functionality of a generic queue data structure.
 * 
 * @param  <T>  the data type stored in the queue
 * 
 * @author      Valentin Gabriel Mitrea
 */
public class Queue<T> {

	private LinkedList<T> elements;

	/**
	 * Constructor for a queue that can grow or shrink dynamically.
	 */
	public Queue() {
		this.elements = new LinkedList<T>();
	}

	/**
	 * Adds one element in the queue.
	 * 
	 * @param  element  element to be added
	 */
	public void push(T element) {
		elements.add(element);
	}

	/**
	 * Gets the element at the front of the queue without removing it.
	 * 
	 * @return  the element at the front of the queue or null if queue is empty
	 */
	public T peek() {
		return elements.peek();
	}

	/**
	 * Removes one element from the queue.
	 * 
	 * @return  the removed element
	 */
	public T pop() {
		return elements.remove();
	}

	/**
	 * Returns the size of the queue.
	 * 
	 * @return  number of elements currently in the queue
	 */
	public int size() {
		return elements.size();
	}

	/**
	 * Checks if queue is empty.
	 * 
	 * @return  true if queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (elements.size() == 0)
			return true;

		return false;
	}

}
