package Lab5;

public class Container {
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
		System.out.println("The object was added to the contianer");
	}
	/**
	 * This method removes the <code> obj </code> from the container. 
	 * It shifts all the elements to make sure that removal of the element
	 * does not create a whole in the container.
	 * @param obj is the object that is removed from the container. 
	 * @return It returns the object that was removed.
	 */
	Object remove(Object obj) {
		System.out.println("The object was removed from the container.");
		return obj;
	}
	/**
	 * This method returns true if the container is empty.
	 * @return It returns true if the container is empty, otherwise false.
	 */
	boolean isEmpty() {
		// you may want to change this return value
		if(list != null) {
			boolean result = true;
			for(int i = 0; i<list.length && result; i++) {
				if(list[i] != null) {
					result = false;
				}
			}
			return result;
		}
		if(set != null) {
			boolean result = true;
			for(int i = 0; i<set.length && result; i++) {
				if(set[i] != null) {
					result = false;
				}
			}
			return result;
		}
		else {
			return false;
		}
		
	}
	/**
	 * This method returns the number of elements stored in the container.
	 * @return It returns the number of elements in the container.
	 */
	int getSize() {
		// you may want to return this return value.
//		if(list != null) {
//			return list.length;
//		}
//		if(set != null) {
//			return set.length;
//		}
//		else {
//			return 0;
//		}
//		
//	}
		return this.size;
	
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
	 * This is the default constructor that sets all the instance variables to their default value. 
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
		// insert your code here. You may want to change the return value. 
		return list[index].toString(); 	
	}
	/**
	 * This method overrides the <code> add </code> method defined in class <code> container</code>, by
	 * adding the <code> obj </code> to the back of <code> list </code> array. 
	 * The original size of the <code> array </code>, is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that 
	 * more elements is added to this array. In case the array does not have enough capacity to add one more element, it grows itself 
	 * by doubling the size of <code> list </code> array.     
	 */
	@Override
//	void add(Object obj) {
//		// insert your code here
//		boolean contains = false;
//		for(int i = 0; i<list.length && (contains == false); i++) {
//			if(list[i] == null) {
//				list[i] = obj;
//				contains = true;
//				this.size = i+1;
//			}
//		}
//		if(contains == false) {
//			Object[] newList = new Object[list.length*2];
//			
//			for(int i = 0; i<list.length; i++) {
//				newList[i] = list[i].toString();
//			}
//			newList[list.length] = obj;
//			list = newList;
//			contains = true;
//			this.size = list.length+1;
//		}
//		Object[] changedList = new Object[this.size];
//		for(int j = 0; j<changedList.length; j++) {
//			changedList[j] = list[j].toString();
//		}
//		list = new Object[changedList.length];
//		for(int j = 0; j<list.length; j++) {
//			list[j] = changedList[j].toString();
//		}
//	}
	void add(Object obj) {
        // insert your code here
        
        if (size >= ORIGINAL_SIZE) {
            Object[] newList = new Object[ORIGINAL_SIZE*2];
            for(int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }
        }
        else {
        	this.list[size] = obj;
        }
        this.size++;
    }

	
	/**
	 * This method removes the first occurrence of <code> obj </code>
	 * from <code> list </code>
	 * @pre <code> obj </code> exists in the <code>list</code> array.
	 * 
	 */
	@Override
//	Object remove(Object obj) {
//		// insert your code here. You may want to change the return value.
//		boolean removed = false;
//		for(int i = 0; i<list.length && !removed; i++) {
//			if(list[i].equals(obj)) {
//				list[i] = null;
//				removed = true;
//			}
//		}
//		return list;
//	}
	Object remove(Object obj) {
        // insert your code here. You may want to change the return value.
        Object[] listRemoved = new Object[list.length-1];
        boolean removed = false;
        int j = 0;
        
        for ( int i = 0; i < size; i++) {
            
            if (this.list[i].equals(obj)) {
                continue;
            }
            listRemoved[j] = this.list[i];
            j++;
        }
        this.size--;
        this.list = listRemoved;
        return obj;
    }
	
	
	/**
	 * This method returns the elements of the MyList in a form of 
	 * [obj1 obj2 obj3 ...]
	 */
	@Override
	public String toString() {
		// insert your code here. You may want to change the return value.		
		String output = "[";
		for(int i = 0; i<list.length; i++) {
			if(list[i] != null) {
				output += list[i].toString()+" ";
			}
			else {
				output += "";
			}
		}
		return output.trim() + "]";
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
		// insert your code here. You may want to change the return value.		
//		boolean contains = false;
//		for(int i = 0; i<set.length && (contains == false); i++) {
//			if(set[i].equals(obj)) {
//				contains = true;
//				break;
//			}
//			
//			if(set[i] == null) {
//				set[i] = obj;
//				contains = true;
//			}
//		}
//		if(contains == false) {
//			Object[] newSet = new Object[size*2];
//			
//			for(int i = 0; i<set.length; i++) {
//				newSet[i] = set[i];
//			}
//			
////			for(int i = 0; i<newSet.length && (contains == false); i++) {
////				if(newSet[i].equals(obj)) {
////					contains = true;
////					break;
////				}
////				
//			newSet[set.length] = obj;
//			set = newSet;
//			
//		}
//	} 

        boolean contains = false;
        
        if (size == set.length) {
            Object[] newSet = new Object[set.length*2];
            
            for (int i = 0 ; i < size; i++) {
                newSet[i] = set[i];
            }
            this.set = newSet;
        }

        for (int i = 0 ; i < size; i++) { 
            if (set[i].equals(obj)) {
                contains = true;
                break;
            }
        }
        
        if (!contains) {
            this.set[size] = obj;
            this.size++;
        }
    }
        

	
	
	/**
	 * This method removes the first occurrence of <code> obj </code>
	 * from <code> set </code>
	 * @pre <code> obj </code> exists in the <code>set</code> array.
	 * 
	 */
	@Override
	Object remove(Object obj) {
		// insert your code here. You may want to change the return value.		
//		boolean removed = false;
//		for(int i = 0; i<set.length && !removed; i++) {
//			if(set[i].equals(obj)) {
//				set[i] = null;
//				removed = true;
//			}
//		}
//		return set;
        Object[] setRemoved = new Object[set.length-1];
        boolean removed = false;
        int j = 0;
        
        for ( int i = 0; i < size; i++) {
            
            if (this.set[i].equals(obj)) {
                continue;
            }
            setRemoved[j] = this.set[i];
            j++;
        }
        this.size--;
        this.set = setRemoved;
        return obj;
	}
	
	/**
	 * This method returns the elements of the MySet in a form of 
	 * [obj1 obj2 obj3 ...]
	 */
	
	@Override
	public String toString() {
		// insert your code here. You may want to change the return value.		
		String output = "[";
		for(int i = 0; i<set.length; i++) {
			if(set[i] != null) {
				output += set[i].toString()+" ";
			}
			else {
				output += "";
			}
		}
		return output.trim() + "]";
	}
	
}
