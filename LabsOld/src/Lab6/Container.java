package Lab6;

public abstract class Container {
	// do not change the value of the following constant.
	protected final int ORIGINAL_SIZE = 10; 
	protected Object[] list; // is a container that stores the element of MyList
	protected Object[] set; // is a container that stores the element of MySet
	protected int size; // this variable holds the actual number of elements that are stored in either of the containers (i.e. MyList or MySet).
	/**
	 * This method adds the <code> obj </code> to the end of the container.
	 * @param obj is the object that is added to the container.
	 */
	void add(Object obj) {
		System.out.println("The object was added to the container");
	}
	/**
	 * This method removes the object at the given index
	 * @param index is the index of the object that is removed.
	 * @return returns the removed object.
	 */
	Object remove(int index) {
		// Change the return value.
		return ((MyList)this).remove(index);
	}

	/**
	 * This method returns true if the container is empty.
	 * @return It returns true if the container is empty, otherwise false.
	 */
	boolean isEmpty() {
		return size == 0 ? true: false;
	}
	/**
	 * This method returns the number of elements stored in the container.
	 * @return It returns the number of elements in the container.
	 */
	int getSize() {
		return size;
	}
	

}

/**
 * 
 * This class simulates an ArrayList, where you can add unlimited number of 
 * elements to the list.
 *
 */
class MyList extends Container{
	/**
	 * This is the default constructor that sets all the instance variables to their defualt value. 
	 */
	public MyList () {
		list= new Object[ORIGINAL_SIZE];
		size = 0; 
	}
	
	/**
	 * This method returns the element that is stored at index <code> index </code>.
	 * @param index is the<code> index </code> at which the element is accessed and returned. 
	 * @return it returns the element stored at the given <code> index </code>.
	 */
	public Object get(int index) {
		Object obj = list[index];
		return obj; 	
	}
	/**
	 * This method overrides the <code> add </code> method defined in class <code> container</code>, by
	 * adding the <code> obj </code> to the back of <code> list </code> array. 
	 * The original size of the <code> array </code>, is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that 
	 * more elements is added to this array. In case the array does not have enough capacity to add one more element, it grows itself 
	 * by doubling the size of <code> list </code> array.     
	 */
	@Override
	void add(Object obj) {
		if (size < list.length ) {
			list[size] = obj; 
		}
		else {
			Object[] arrayCopy = new Object[2*list.length];
			int i; 
			for(i = 0; i < list.length; i++) {
				arrayCopy[i] = list[i]; 
			}
			arrayCopy[i] = obj;
			list = arrayCopy; 
		}
		size++; 
	}
	/**
	 * This method removes the object at the given index.
	 * items at index + 1, index + 2, ... should be shifted to index, index + 1, ....
	 * @pre <code> index </code> is in a valid range. 
	 */
	@Override
	Object remove(int index) {
		// implement this code. You may need to change the return value
		Object[] newList = new Object[list.length-1];
		Object obj = list[index];
		for(int i=0; i<newList.length; i++) {
			if(i<index) {
				newList[i] = list[i];
			}
			else {
				newList[i] = list[i+1];
			}
		}
		size--;
		list = newList;
		
		return obj;
	}



	/**
	 * This method returns the elements of the MyList in a form of 
	 * [obj1 obj2 obj3 ...]
	 */
	@Override
	public String toString() {
		String result= "[";
		for(int i = 0; i<this.getSize(); i++)
			result += list[i] + " ";
		result = result.trim() + "]";
		return result;
	}
}


class MySet extends Container{
	public MySet() {
		set = new Object[ORIGINAL_SIZE];
		size = 0; 
	}
	
	/**
	 * This method overrides the <code> add </code> method defined in class <code> container</code>, by
	 * adding the <code> obj </code> to the back of <code> set </code> array. 
	 * The original size of the <code> set </code>, is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that 
	 * more elements is added to this set. In case the set does not have enough capacity to add one more element, it grows itself 
	 * by doubling the size of <code> set </code> array.      
	 */
	
	@Override
	void add(Object obj) {
		// if the array is full, double its size
		if (size == set.length ) {
			Object[] setCopy = new Object[2*set.length];
			for(int i = 0; i <this.getSize(); i++) {
				setCopy[i] = set[i]; 
			}
			set = setCopy; 
		}
		// check if the obj is already exists
		boolean found = false; 
		for (int i = 0; i < this.getSize(); i++) {
			if (set[i].equals(obj)) {
				found = true; 
				break;
			}
		}
		// if the obj does not exists, add it to the set
		if (!found) {
			set[size] = obj; 			
			size++; 
		}
		
	}
	/**
	 * This method is an optional method, which means it has not been defiend for this class. 
	 * @param index
	 * @return
	 */
	@Override
	Object remove(int index) {
		// Please do not change this code. 
		throw new UnsupportedOperationException();
	}


	/**
	 * This method returns the elements of the MySet in a form of 
	 * [obj1 obj2 obj3 ...]
	 */
	
	@Override
	public String toString() {
		String result= "[";
		for(int i = 0; i<this.getSize(); i++)
			result += set[i] + " ";
		result = result.trim() + "]";
		return result;
	}
	
}


/** 
 * This class implements a Stack.
 *
 */


class Stack{
	private Container stack;  
	// no other instance variable should be defined here. 
	
	/**
	 * This is the constructor that initializes <code> stack </code>.
	 */
	public Stack() {
		// insert your code here. only one line should be added here. 
		stack = new MyList();
	}
	
	/**
	 * This method adds the object to the top of the stack.
	 * @param object is the object that is added to the top of the stack.
	 */
	public void push(Object object) {
		// insert your code here. only one line should be added here. 
		stack.add(object);;
	}
	
	/**
	 * This method removes an object from the top of the stack. 
	 * @return It returns the object that is returned from the top of the stack.
	 */
	public Object pop() {
		// insert your code here. only one line should be added here. You may need to change the return value.
		return stack.remove(this.getSize()-1);
	}
	
	/**
	 * This method returns the object, which is at the top of the stack without removing it from the stack.
	 * @return It returns the element, which is found on top of the stack.
	 */
	public Object top() {
		// insert your code here. only one line should be added here. You may want to change the return value.
		Object obj = ((MyList)stack).get(getSize()-1);
		return obj;		
	}
	
	/**
	 * This method shows how many elements are in the stack.
	 * @return  It returns the number of elements in the stack.
	 */
	public int getSize() {
		// change the return value. No any other code should be added. 
		return stack.getSize();
	}
}

