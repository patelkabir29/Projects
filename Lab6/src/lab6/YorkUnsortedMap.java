package lab6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class YorkUnsortedMap<K, V> implements Map<K, V> {

	
	
	// -------------- nested MapEntry Class ------------------
	private static class MapEntry<K, V> implements Entry<K, V> {
		private K key;
		private V value;

		/**
		 * Constructor to set the key and value of this entry
		 * 
		 * @param key   the key
		 * @param value the value
		 */
		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			// TODO: Your implementation of this method starts here
			return this.key;
			
		}

		@Override
		public V getValue() {
			// TODO: Your implementation of this method starts here
			return this.value;
			
		}

		/**
		 * Sets the value of this Entry with specified value
		 * 
		 * @param newValue the new value
		 * @return old value of this entry
		 */
		public V setValue(V newValue) {
			// TODO: Your implementation of this method starts here
			V temp = this.value;
			this.value = newValue;
			return temp;
		}

		/**
		 * String representation for map entry
		 */
		@Override
		public String toString() {
			return "<" + key + ", " + value + ">";
		}

	}

	// ---- end of nested MapEntry class----------------------
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define default load factor
	private static final double LOADFACTOR = 0.5;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define the default hash-table size. Must be a power of 2
	private static final int INITCAPACITY = 4;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define the maximum hash-table size. 1 << 30 is same as 2^30
	private static final int MAXCAPACITY = 1 << 30;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// The current hash-table capacity. Capacity must be a power of 2
	private int capacity;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// User specify a load factor used in this hash table
	private double loadFactor;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// The number of entries in the map
	private int size = 0;
	
	private int reCapacity(int capacity) {
		int n = 1;
		int i = 0;
		while(capacity>n) {
			n = n << (++i);
		}
		
		return n;
	}
	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkUnsortedMap You can use java.util.ArrayList or java.util.LinkedList
	 * (DoublyLinked) List to implement and store the map entries
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private List<MapEntry<K, V>> entries;

	/**
	 * no argument constructor Construct a map with the default capacity and load
	 * factor
	 */
	public YorkUnsortedMap() {
		// TODO: Your implementation of this method starts here
		this.entries = new ArrayList<>();
		this.capacity = INITCAPACITY;
		this.loadFactor = LOADFACTOR;
	}

	/**
	 * One argument constructor Construct a map with the specified initial capacity
	 * and default load factor
	 */
	public YorkUnsortedMap(int capacity) {
		// TODO: Your implementation of this method starts here
		this();
		this.capacity = capacity;
	}

	/**
	 * Construct a map with the specified initial capacity and load factor. Note:
	 * the capacity of map must be power of 2 User/client can specify any value as
	 * map capacity. You should make sure that the map is created with the power of
	 * 2 capacity that is greater than the user's given capacity. For example, if
	 * the user specifies the input capacity as 13, you should create a map with a
	 * capacity of 16.
	 * 
	 * @param capacity   map capacity specified by client
	 * @param loadFactor map loading factor
	 */
	public YorkUnsortedMap(int capacity, double loadFactor) {
		// TODO: Your implementation of this method starts here
		this();
		this.capacity = this.reCapacity(capacity);
		this.loadFactor = loadFactor;
	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return this.size;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return size == 0;
		
	}

	@Override
	public V get(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if(key == null) {
			throw new NullPointerException();
		}
		
		for(MapEntry<K, V> e : entries) {
			if(e.getKey().equals(key)) {
				return e.getValue();
			}
		}
		return null;
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		entries.clear();
		this.size = 0;
	}

	@Override
	public V put(K key, V value) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if(key == null) throw new NullPointerException();
		
		if(this.size >= this.capacity) {
			this.capacity = this.reCapacity(capacity+1);
		}
		
		boolean added = false;
		for(MapEntry<K, V> e : entries) {
			if(e.getKey().equals(key)) {
				V temp = e.getValue();
				e.setValue(value);
				added = true;
				return temp;
			}
		}
		if(!added) {
			entries.add(new MapEntry<K, V>(key, value));
			size++;
		}
	
		return null;
	}

	@Override
	public V remove(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if(key == null) throw new NullPointerException();
		
		for(MapEntry<K, V> e : entries) {
			if(e.getKey().equals(key)) {
				V temp = e.getValue();
				entries.remove(e);
				size--;
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean containsKey(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if(key == null) throw new NullPointerException();
		
		for(MapEntry<K, V> e : entries) {
			if(e.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(V value) {
		// TODO: Your implementation of this method starts here
		for(MapEntry<K, V> e : entries) {
			if(e.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterable<K> keySet() {
		// TODO: Your implementation of this method starts here
		List<K> keys = new ArrayList<>();
		for(MapEntry<K, V> e : entries) {
			keys.add(e.getKey());
		}
		return keys;
	}

	@Override
	public Iterable<V> values() {
		// TODO: Your implementation of this method starts here
		List<V> values = new ArrayList<>();
		for(MapEntry<K, V> e : entries) {
			values.add(e.getValue());
		}
		return values;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO: Your implementation of this method starts here
		List<Entry<K, V>> list = new ArrayList<>();
		for(MapEntry<K, V> e : entries) {
			list.add(e);
		}
		return list;
	}

	/**
	 * Return String value represent the content of map 
	 *  if Map contains only two entries 
	 *  put("A1", 124); and put("A2", 125);
	 *  the output will be 
	 *   "[<A1, 124>,<A2, 125>]"
	 */
	@Override
	public String toString() {

		// TODO: Your implementation of this method starts here
		 String str = "[";
		 for(int i = 0; i < size; i++) {
			 MapEntry<K, V> e = entries.get(i);
			 str += "<"+ e.getKey() + ", " + e.getValue() + ">";//or MapEntry<K, V>.toString()
			 
			 if(i != size-1)
				 str += ",";
		 }
		 str += "]";
		 
		 return str;

	}

}
