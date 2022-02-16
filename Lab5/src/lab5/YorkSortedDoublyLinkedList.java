package lab5;

import java.util.*;

/**
 * 
 * You need to complete the implementation of a YorkSortedDoublyLinkedList class
 * The YorkSortedDeoublyLinkedList uses sentinel nodes, header and trailer.
 * Therefore, you need to keep in mind that the first element of a nonempty list
 * is stored in the node just after the header (not in the header itself), and
 * similarly that the last element is stored in the node just before the
 * trailer.
 * 
 * @param <E>
 */
public class YorkSortedDoublyLinkedList<E> implements List<E> {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;

		public Node(E element) {
			this.element = element;
		}
	}

	/////////////////////////////////////
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> header; // header sentinel
	private Node<E> trailer; // trailer sentinel
	private int size = 0; // number of elements in the list
	//////////////////////////////////
	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkSortedDoublyLinkedList 
	 */

	

	public YorkSortedDoublyLinkedList() {
		// TODO: Your implementation of this method starts here
		header = new Node<>(null);
		trailer = new Node<>(null);
		header.next = trailer;
		trailer.prev = header;
	}

	/**
	 * 
	 * Take the elements from the input array one by one and then insert them into
	 * the list. you should insert the elements at the end of the list
	 */
	public YorkSortedDoublyLinkedList(E[] objects) {
		// TODO: Your implementation of this method starts here
		this();
		for (E object : objects) {
			addLast(object);
		}

	}

	/**
	 * Returns (but does not remove) the first element stored in the first node of
	 * the list. if the list is empty return null otherwise return the first element
	 * stored inside the first node of the list
	 * 
	 * @return
	 */
	public E getFirst() {
		if (isEmpty()) {
            return null;
        }
		else {
            return header.next.element;
        }

	}

	/**
	 * Add the newly created node to the beginning of this list
	 * 
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> first = header.next;
        Node<E> newFirst = new Node<>(null);
        newFirst.element = e;
        newFirst.prev = header;
        newFirst.next = first;
        first.prev = newFirst;
        header.next = newFirst;
        
        size++;
	}

	/**
	 * Add the newly created node to the end of this list
	 * 
	 * 
	 * 
	 * @param e
	 */

	public void addLast(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> last = trailer.prev;
		Node<E> newLast = new Node<>(null);
		newLast.element = e;
		newLast.next = trailer;
		newLast.prev = last;
		last.next = newLast;
		trailer.prev = newLast;
		
		size++;
	}

	/**
	 * Return the last element stored inside the last node in this list if the list
	 * is empty returns null.
	 * 
	 * 
	 * @return
	 */
	public E getLast() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
            return null;
        }
		else {
            return trailer.prev.element;
        }

	}

	/**
	 * Remove the first node and then return the element stored inside this node the
	 * method return null if this list is empty
	 * 
	 * 
	 * @return
	 */

	public E removeFirst() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
            return null;
        }
		else {
            return remove(0);
        }
	}

	/**
	 * Remove the last node in this list then return the element stored inside the
	 * last node. the method returns null if this list is empty
	 * 
	 * 
	 * @return
	 */
	public E removeLast() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
            return null;
        }
		else {
            return remove(size - 1);
        }
	}

	/**
	 * 
	 * Search this list and return the first match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the lowest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * @param e
	 * @return
	 */
	public int indexOf(E e) {
		// TODO: Your implementation of this method starts here

		Node<E> node = header.next;
        int i = 0;
        while (node.next != null) {
            if (node.element == e) {
                return i;
            }
            i++;
            node = node.next;
        }
        return -1;
	}

	/**
	 * Search this list and return the last match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the largest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * @param e
	 * @return
	 */

	public int lastIndexOf(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> node = trailer.prev;
        int i = size - 1;
        while (node.prev != null) {
            if (node.element == e) {
                return i;
            }
            node = node.prev;
            i--;
        }
        return -1;
	}

	/**
	 * Sorts a list in ascending order by using a Comparator object
	 * 
	 * @param comparator
	 */
	public void sortAscending(Comparator<E> comparator) {

		// TODO: Your implementation of this method starts here
		quickSort(header.next, trailer.prev, comparator, 0);
	}

	/**
	 * 
	 * Sorts a list in descending order by using a Comparator object
	 * 
	 * 
	 * @param comparator
	 */
	public void sortDescending(Comparator<E> comparator) {

		// TODO: Your implementation of this method starts here
		quickSort(header.next, trailer.prev, comparator, 1);		
	}

	///////

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return size;

	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return size == 0;
		
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		return getNodeAt(i).element;

	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		getNodeAt(i).element = e;
        return e;

	}

	@Override
	public void add(int i, E e) {
		// TODO: Your implementation of this method starts here
		if (i >= size) {
			addLast(e);
		}
		else {
			Node<E> node = getNodeAt(i);
			Node<E> pre = node.prev;
			Node<E> newNode = new Node<>(e);
			newNode.next = node;
			newNode.prev = pre;
			pre.next = newNode;
			node.prev = newNode;

			size++;
		}
	}

	/**
	 * 
	 * Inserts the new element e after the specified index i in this list. Shifts
	 * the elements after the index i (if any)
	 * 
	 * Remember that You need if the index i is greater than the list size then you
	 * need to add the element e at the end of the list
	 * 
	 * @param i the index at which the new element should be stored
	 * @param e the new element to be stored
	 */

	public void addAfter(int i, E e) {
		// TODO: Your implementation of this method starts here
		if (i >= size) {
			addLast(e);
		}
		else {
			Node<E> node = getNodeAt(i);
			Node<E> aft = node.next;
			Node<E> newNode = new Node<>(e);
			newNode.prev = node;
			newNode.next = aft;
			aft.prev = newNode;
			node.next = newNode;
			size++;
		}			
	}

	/**
	 * Removes all elements between the given lowerindex and upperindex inclusive.
	 * shifting all subsequent elements in the list closer to the front. Index: 0 1
	 * 2 3 4 5 6 Example: if list contains [ 1, 2, 3, 5, 6, 7, 8] you call
	 * removeBetween(2,4) then list will contains [1, 2, 7, 8] Hence, three elements
	 * are removed
	 * 
	 * Note: if the lower or upper index is greater than the size of the list then 
	 * the lower or upper index will be updated to be the end of the list
	 * 
	 * 
	 * 
	 * 
	 * @param lowerindex the lower index
	 * @param upperindex the upper index,
	 * @throws IndexOutOfBoundsException if the index is negative or lowerindex is
	 *                                   greater than upperindex
	 * 
	 */

	public void removeBetween(int lowerindex, int upperindex) {
		// TODO: Your implementation of this method starts here
		if (upperindex < lowerindex) throw new IndexOutOfBoundsException();
		
		for (int i=lowerindex; i<=upperindex; i++) {
			remove(i);
		}
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		return remove(getNodeAt(i));
	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO Auto-generated method stub
		if (e == null) throw new NullPointerException();
		
        return indexOf(e) >= 0;
	}

	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (e == null) throw new NullPointerException();
        
		int i = indexOf(e);
        if (i == -1){
        	return false;
        }
        remove(i);
        return true;
	}

	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean result = false;
        for (E object : otherList) {
            if (object == null) throw new NullPointerException();
            addLast(object);
            result = true;
        }
        
        return result;
	}

	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean result = false;
        for (E object : otherList) {
            if (object == null) throw new NullPointerException();
            
            int i = indexOf(object);
            while (i != -1) {
                remove(i);
                result = true;
                i = indexOf(object);
            }
        }
        
        return result;
	}

	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean result = false;

        Node<E> node = header.next;
        
        while (node.next != null) {
            if (!otherList.contains(node.element)) {
                remove(node);
                result = true;
            }
            node = node.next;
        }

        return result;
	}

	/**
	 * Return String value represent the content of list as example "[30, 110, -110,
	 * -2, 1322]"
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		String out = "[";

        Node<E> node = header.next;
        while (node.next != null) {
            out = out.concat(node.element + ", ");
            node = node.next;
        }

        if (out.endsWith(", "))
            out = out.substring(0, out.length() - 2);

        out = out.concat("]");

        return out;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		return new Iterator<E>() {
            Node<E> node = header;
            Boolean b = false;

            @Override
            public boolean hasNext() {
                return node.next.next != null;
            }

            @Override
            public E next() {
                node = node.next;
                b = true;
                return node.element;
            }

            @Override
            public void remove() {
                if (b == false) {
                    throw new IllegalStateException();
                }
                Node<E> pre = node.prev;
                Node<E> aft = node.next;
                pre.next = aft;
                aft.prev = pre;
                
                size--;
                b = false;
            }
        };
	 }

    private E remove(Node<E> node) {
        Node<E> pre = node.prev;
        Node<E> aft = node.next;
        pre.next = aft;
        aft.prev = pre;
        
        size--;
        
        return node.element;
    }

    private Node<E> getNodeAt(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        Node<E> node = header.next;
        
        for (int j=1; j<=i; j++) {
            node = node.next;
        }
        return node;
    }

    private Node<E> partition(Node<E> start, Node<E> finish, Comparator<E> comp, int order) {
        Node<E> node = finish;
        Node<E> i = start.prev;
        for (Node<E> p = start; p != finish; p = p.next) {
			boolean condition = ((order == 0) == (comp.compare(node.element, p.element) > 0));
            
			if (condition) {
                i = (i == null ? start : i.next);
                E temp = i.element;
                i.element = p.element;
                p.element = temp;
            }
        }
        if (i==null) {
        	i = start;
        }
        else {
        	i = i.next;
        }
        E temp = i.element;
        i.element = node.element;
        node.element = temp;
        return i;
    }

    private void quickSort(Node<E> start, Node<E> finish, Comparator<E> comparator, int order) {
        if (finish != null && start != finish && start != finish.next) {
            Node<E> p = partition(start, finish, comparator, order);
            quickSort(start, p.prev, comparator, order);
            quickSort(p.next, finish, comparator, order);
        }
    }

}
