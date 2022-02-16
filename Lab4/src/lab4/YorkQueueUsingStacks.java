package lab4;

import java.util.*;

/**
 * 
 * Implement the queue interface using two stacks 
 * 
 * @param <E>
 */
public class YorkQueueUsingStacks<E> implements Queue<E> {

	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	private Stack<E> inbox;
	private Stack<E> outbox;
	private int count = 0;

	/**
	 * No argument constructor
	 */
	public YorkQueueUsingStacks(){
		inbox = new YorkArrayStack<>();
		outbox = new YorkArrayStack<>();
	}

	/**
	 * Returns the number of elements in the queue.
	 *
	 * @return number of elements in the queue
	 */
	@Override
	public int size() {
		return count;
	
	}

	/**
	 * Tests whether the queue is empty.
	 *
	 * @return true if the queue is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Removes all the elements from this queue and everything back to the initial
	 * state, clears inbox and outbox and sets stack size back to the initial size.
	 */
	@Override
	public void clear() {
		inbox.clear();
		outbox.clear();
		count = 0;
	}

	/**
	 * Inserts an element at the rear of the queue.
	 *
	 * @param e the element to be inserted
	 */
	@Override
	public void enqueue(E e) {
		inbox.push(e);
		count++;
	}

	/**
	 * Returns, but does not remove, the first element of the queue.
	 *
	 * @return the first element of the queue
	 * @throws NoSuchElementException If the queue is empty.
	 *
	 */
	@Override
	public E first() throws NoSuchElementException {
		if(outbox.isEmpty()) {
			while(!inbox.isEmpty())
				outbox.push(inbox.pop());
		}
		if(!outbox.isEmpty()) {
			return outbox.top();
		} else throw new NoSuchElementException();
	}

	/**
	 * Removes and returns the first element of the queue.
	 *
	 * @return element removed
	 * @throws NoSuchElementException If the queue is empty.
	 */
	@Override
	public E dequeue() throws NoSuchElementException {
		if(outbox.isEmpty())
			while(!inbox.isEmpty())
				outbox.push(inbox.pop());

		E temp;

		if(!outbox.isEmpty()) {
			temp = outbox.pop();
			count--;
		} else throw new NoSuchElementException();

		return temp;
	}

	/**
	 * Returns {@code true} if this queue contains the specified element. More
	 * formally, returns {@code true} if and only if this queue contains at least one
	 * element {@code e} such that {@code equals(e, element)}.
	 *
	 * @param e element whose presence in this queue is to be tested
	 * @return {@code true} if this queue contains the specified element
	 *
	 * @throws NullPointerException if the specified element is null
	 *
	 */
	@Override
	public boolean contains(E e) throws NullPointerException {
		if (e == null) throw new NullPointerException();

		boolean result = false;
		Stack<E> temp = new YorkArrayStack<>();

		while (!outbox.isEmpty()) {
			temp.push(outbox.pop());
		}
		while (!temp.isEmpty()) {
			E ele = temp.pop();
			if (ele == e) result = true;
			outbox.push(ele);
		}

		temp.clear();

		while (!result && !inbox.isEmpty()) {
			temp.push(inbox.pop());
		}
		while (!temp.isEmpty()) {
			E ele = temp.pop();
			if (ele == e) result = true;
			inbox.push(ele);
		}

		return result;
	}

	/**
	 *
	 * Return String value represent the content of queue.
	 * Displays the contents of the queue in insertion order (FIFO), so the
	 * most-recently inserted element is the last element of string
	 *
	 */
	@Override
	public String toString() {
		String str = "[";
		Stack<E> temp = new YorkArrayStack<>();

		while (!outbox.isEmpty()) {
			temp.push(outbox.pop());
		}
		while (!temp.isEmpty()) {
			E ele = temp.pop();
			str = str.concat(ele + ", ");
			outbox.push(ele);
		}

		temp.clear();

		while (!inbox.isEmpty()) {
			temp.push(inbox.pop());
		}
		while (!temp.isEmpty()) {
			E ele = temp.pop();
			str = str.concat(ele + ", ");
			inbox.push(ele);
		}

		if (str.endsWith(", ")) {
			str = str.substring(0, str.length() - 2);
		}
		str = str.concat("]");
		return str;
	}
}
