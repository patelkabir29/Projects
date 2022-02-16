package lab4;

import java.util.*;

/**
 * 
 * Queue using expandable circular Array of generic type E. This is called a
 * "circular" queue with expandable dataay. if the queue (dataay) is full, create
 * a new queue (dataay) of twice the size, and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayQueue<E> implements Queue<E> {

	/**
	 * Initial size, default size, for the queue
	 * remember that an empty queue has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */

	private E[] data;
	private int c = 0;
	private int first = 0;
	
	
	/**
	 * No argument constructor
	 */
	public YorkArrayQueue() {
		// TODO: Your implementation of this method starts here
		
	}

	public YorkArrayQueue(int capacity) {
		// TODO: Your implementation of this method starts here

		data = (E[]) new Object[capacity];
	}

	/**
	 * Constructor takes dataay of elements and then add then to the end of the Array
	 * list
	 * 
	 * @param objects
	 */

	public YorkArrayQueue(E[] objects) {
		data = objects.clone();
		c  = objects.length;
	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return c;

	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return c == 0;
		
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		data = (E[]) new Object[INITSIZE];
		c = 0;
		first = 0;
		
	}

	@Override
	public void enqueue(E e) {
		// TODO: Your implementation of this method starts here
		if (c == data.length) {
			E[] newD = (E[]) new Object[c * 2];
			for (int i = 0; i < c; i++) {
				newD[i] = data[i + first];
			}
			data = newD;
		}

		int rear = ( first + c ) % data.length;
		data[rear] = e;
		c++;



	}

	@Override
	public E first() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) throw new NoSuchElementException();
		return data[first];
			
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) throw new NoSuchElementException();
		E ele = data[first];
		data[first] = null;
		first = (first + 1) % data.length;
		c--;
		return ele;


	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (e == null) throw new NullPointerException();
		int rear = ( first + c ) % data.length;
		for (int i = first; i <= rear; i++) {
			if (data[i] == e) {
				return true;
			}
		}
		return false;

		
	}

	
	/**
	 * 
	 *  Return String value represent the content of queue as 
	 * example "[30, 110, -110, -2, 1322]"
	 * 
	 * remember that you should displays the contents of the queue in insertion order (FIFO), so the
	 * most-recently inserted element should be the last element
	 * 
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		String str = "[";
		int rear = ( first + c ) % data.length;
		for (int i = first; i <= rear; i++) {
			if (data[i] != null)
				str = str.concat(data[i] + ", ");
		}
		if (str.endsWith(", "))
			str = str.substring(0, str.length() - 2);
		str = str.concat("]");
		return str;
	}
	
	



	
	

}
