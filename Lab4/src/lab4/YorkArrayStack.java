package lab4;

import java.util.EmptyStackException;

/**
 * 
 * Stack using expandable Array of generic type E.
 * if the stack (array) is full, create a new stack (array) of twice the size, and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayStack<E> implements Stack<E> {

	/**
	 * Initial size, default size, for the Array of stack 
	 * remember that an empty stack has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;
	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	private E[] data;
	private int c = 0;

	/**
	 * No argument constructor
	 */
	public YorkArrayStack() {
		this(INITSIZE);
	}

	/**
	 * Constructor takes initial capacity of stack
	 *
	 * @param capacity internal capacity of the stack
	 */
	public YorkArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}

	/**
	 * Constructor takes array of elements and then add then to 
	 * the end of the Array list 
	 * @param objects
	 */
	public YorkArrayStack(E[] objects) {
		data = objects.clone();
		c = objects.length;
	}

	/**
	 * Returns the number of elements in the stack.
	 * @return number of elements in the stack
	 */
	@Override
	public int size() {
		return c;
	}

	/**
	 * Removes all the elements from the stack and everything back to the initial
	 * state, including setting its size back to the initial size.
	 */
	@Override
	public void clear() {
		data = (E[]) new Object[INITSIZE];
		c = 0;
	}

	/**
	 * Tests whether the stack is empty.
	 * @return true if the stack is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return c == 0;
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * @return top element in the stack
	 *
	 * @throws java.util.EmptyStackException if stack empty
	 */
	@Override
	public E top() throws EmptyStackException {
		if (isEmpty()) throw new EmptyStackException();
		return data[c - 1];
	}

	/**
	 * Inserts an element at the top of the stack.
	 * If the stack is full,
	 * creates a new stack of twice the size, and copy the elements.
	 *
	 * @param e the element to be inserted
	 */
	@Override
	public void push(E e) {
		if (c == data.length) {
			E[] newD = (E[]) new Object[c * 2];
			for (int i = 0; i < c; i++) {
				newD[i] = data[i];
			}
			data = newD;
		}
		data[c++] = e;
	}

	/**
	 * Removes and returns the top element from the stack.
	 *
	 * @return element removed
	 * @throws java.util.EmptyStackException() if stack empty
	 */
	@Override
	public E pop() {
		if (isEmpty()) throw new EmptyStackException();
		E ele = data[c - 1];
		data[c - 1] = null;
		c--;
		return ele;
	}
}
