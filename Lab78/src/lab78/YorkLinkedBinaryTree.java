package lab78;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
 * preorder traversal algorithm to visit tree position or elements.
 * 
 * In a YorkLinkedBinaryTree tree, we adopt a convention in which we set a node
 * parent pointer to itself when removed from a tree to recognize it as an
 * invalid position later on. Thus, in your implementation for the
 * YorkLinkedBinaryTree tree, you must validate the received input position
 * every time to ensure that it is a valid tree node.
 * 
 * Note: You are responsible for creating and running the tests necessary to ensure 
 * that you have correct implementation of YorkLinkedBinaryTree tree. 
 * 
 *
 */
public class YorkLinkedBinaryTree<E> implements BinaryTree<E> {

	
	// -------------- nested Node Class ------------------
	protected static class Node<E> implements Position<E> {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		private E element; 
		private Node<E> parent; 
		private Node<E> left; 
		private Node<E> right; 
		//----------------------------
		
		/** 
		 * Constructs a node with the given element and neighbors. 
		 * */
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			// TODO: Your implementation of this method starts here
			this.element = e;
			this.parent = above;
			this.left = leftChild;
			this.right = rightChild;
		}
	

		public Node<E> getParent() {
			// TODO: Your implementation of this method starts here
			return this.parent;
		}

		public Node<E> getLeft() {
			// TODO: Your implementation of this method starts here
			return this.left;
		}

		public Node<E> getRight() {
			// TODO: Your implementation of this method starts here
			return this.right;
		} 

		public void setElement(E e) {
			// TODO: Your implementation of this method starts here
			this.element = e;
		}

		public void setParent(Node<E> parentNode) {
			// TODO: Your implementation of this method starts here
			this.parent = parentNode;
		}

		public void setLeft(Node<E> leftChild) {
			// TODO: Your implementation of this method starts here
			this.left = leftChild;
		}

		public void setRight(Node<E> rightChild) {
			// TODO: Your implementation of this method starts here
			this.right = rightChild;
		}

		@Override
		public E getElement() throws IllegalStateException {
			// TODO: Your implementation of this method starts here
			if(this.element == null) {
				throw new IllegalStateException();
			}
			return this.element;
			
		}

	}
	//---- end of nested Node class----------------------
	
	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkLinkedBinaryTree 
	 */
	
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> root;

	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size;

	
	/**
	 * Constructs an empty tree
	 */
	public YorkLinkedBinaryTree() {
		// TODO: Your implementation of this method starts here
		this.root = null;
		this.size = 0;
	}

	@Override
	public Position<E> root() {
		// TODO: Your implementation of this method starts here
		return this.root;
		
	}
	public void setRoot(Node<E> node) {
		this.root = node;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(p == null) {
			throw new IllegalArgumentException();
		}
		return ((Node<E>)p).parent;
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Queue<Position<E>> children = new LinkedList<Position<E>>();
	    if (left(p) != null)
	      ((LinkedList<Position<E>>) children).addLast(left(p));
	    if (right(p) != null)
	      ((LinkedList<Position<E>>) children).addLast(right(p));
	    return children;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Position<E> tmp = errorCheck(p);
		Node<E> node = (Node<E>) p;
		if(node.left == null && node.right == null) {
			return 0;
		}
		if(node.left != null && node.right == null) {
			return 1;
		}
		if(node.left == null && node.right != null) {
			return 1;
		}
		if(node.left != null && node.right != null) {
			return 2;
		}
	return 0;

	}

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Position<E> tmp = errorCheck(p);		
	    return (left(p)!=null || right(p)!=null);
	}
	

	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Position<E> tmp = errorCheck(p);
	    return (left(p)==null && right(p)==null);
	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Position<E> tmp = errorCheck(p);
	    return (p.equals(root())); 
	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return this.size == 0;
		
	}
	
	/**
	 *  Places element e at the root of an empty tree and returns its new Position.
	 *  
	 * @param e element of root 
	 * @return  position of root 
	 * @throws IllegalStateException if the tree is not empty
	 */
	
	public Position<E> addRoot(E e) throws IllegalStateException {
		// TODO: Your implementation of this method starts here
		if(!isEmpty())
			throw new IllegalStateException();
		size = 1;
		root = new Node<E>(e,null,null,null);
		return root;

	}
	
	/**
	 * Compute the depth of any given valid position by returning the number of
	 * levels separating Position p from the root.
	 * 
	 * @param p A valid Position within the tree
	 * @return Returns the number of levels separating Position p from the root.
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	public int depth(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> node = (Node<E>) p;
		int i;
		for(i=0; !node.equals(root); i++) {
			node = node.parent;
		}
		return i;
	}

	/**
	 * 
	 * @param p A valid Position within the tree
	 * @return Returns the height of the subtree rooted at Position p.
	 * @throws IllegalArgumentException
	 */
	public int height(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return heightHelper((Node<E>) p);
	}

	/**
	 * Return the height of this binary tree
	 * 
	 * @return the height of this binary tree
	 */
	public int height() {
		// TODO: Your implementation of this method starts here
		return heightHelper(this.root);
	}
	
	//helper method for recursion
	public int heightHelper(Node<E> node)
	{
		if (node == null) {
			return 0;
		}

		return 1 + Math.max(height(node.left), height(node.right));
	}

	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> k = (Node<E>) errorCheck(p);
		Node<E> parentNode = k.getParent();
		if(parentNode.getLeft() == null) {
			return null;
		}
		Position<E> leftNode = k.getLeft();
		if (leftNode == null)
			throw new IllegalArgumentException();
		return leftNode;

	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> k = (Node<E>) errorCheck(p);
		Node<E> parentNode = k.getParent();
		if(parentNode.getRight() == null) {
			return null;
		}
		Position<E> rightNode = k.getRight();
		if (rightNode == null)
			throw new IllegalArgumentException();
		return rightNode;

	}

	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> k = (Node<E>) errorCheck(p);
		Node<E> parentNode = k.getParent();
		if(parentNode.getRight() == null && parentNode.getLeft() == null) {
			return null;
		}

		if (parentNode != null) {
			Position<E> siblingNode;
			Position<E> leftNode = parentNode.getLeft();
			if (leftNode == k)
				siblingNode = parentNode.getRight();
			else
				siblingNode = parentNode.getLeft();
			if (siblingNode != null)
				return siblingNode;
		}
		return null;
	}

	
	/**
	 * insert as the left child of P to contain the element e, return the newly
	 * inserted node, 
	 * Creates a new left child of Position p storing element e; returns its  Position.
	 *  
	 * @param p  the position where the left child will be added 
	 * @param e  the element that will be added as the left child of position p
	 * @return  the Position of the newly added left child 
	 * @throws IllegalArgumentException if p is not a valid Position for this tree or 
	 * 									the given position has already a left child 
	 */
	public Position<E> insertLeft(Position<E> p, E e) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Position<E> k = errorCheck(p);
	    Position<E> leftNode = ((Node<E>)k).left;
	    if (leftNode != null)
	      throw new IllegalArgumentException("Node already has a left child");
	    Position<E> node = new Node<E>(e, (Node<E>)k, null, null);
	    ((Node<E>)k).setLeft((Node<E>)node);
	    size++;
	    return node;

	}
	

	/**
	 * insert as the right child of P to contain the element e, return the newly
	 * inserted node 
	 * @param p the position where the right child will be added
	 * @param e the element that will be added as the right child of position p
	 * @return the Position of the newly added right child
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 *                                  or the given position has already a right
	 *                                  child
	 */
	public Position<E> insertRight(Position<E> p, E e) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Position<E> k = errorCheck(p);
	    Position<E> rightNode = ((Node<E>)k).right;
	    if (rightNode != null)
	      throw new IllegalArgumentException("Node already has a right child");
	    Position<E> node = new Node<E>(e, (Node<E>)k, null, null);
	    ((Node<E>)k).setRight((Node<E>)node);
	    size++;
	    return node;
	}


	/**
	 * Replaces the element at Position p with element e and returns the old
	 * element.
	 *
	 * @param p the input Position need to be updated
	 * @param e the new element
	 * @return the old element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		if(p == null) {
			throw new IllegalArgumentException();
		}
		Node<E> pos = (Node<E>)p;
		pos.setElement(e);
		
		return e;
	}
	
	/**
	 *  Remove position p if p has at most one child and return p's parent 
	 * 
	 * @param p  the input position that needs to be removed from the tree 
	 * @return    the parent of the removed position
	 * @throws IllegalArgumentException  if p is not a valid Position for this tree or 
	 * 										p has two children
	 */
	public Position<E> remove(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		if(p == null) {
			throw new IllegalArgumentException();
		}

		Node<E> node = (Node<E>)p;
		
		if(node.left == null || node.right == null) {
			if((node.parent).left.element == node.element) {
				node.parent.setLeft(null);
				node.setParent(null);
				size--;
			}
			else if((node.parent).right.element == node.element) {
				node.parent.setRight(null);
				node.setParent(null);
				size--;
			}
			return node;
		}
		else {
			throw new IllegalArgumentException();
		}

	}
	
	
	/**
	 * Attaches two sub-trees t1 and t2, respectively, as the left and right subtree
	 * of the leaf Position p. After you successfully added t1 and t2 to a new tree
	 * and became part of a big tree, the t1 and t2 are set to empty trees.
	 *
	 * @param p  a leaf of the tree
	 * @param t1 a completely independent tree whose structure becomes the left
	 *           child of p
	 * @param t2 a completely independent tree whose structure becomes the right
	 *           child of p
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 *                                  or p is not a leaf
	 * 
	 */
	public void attach(Position<E> p, YorkLinkedBinaryTree<E> t1, YorkLinkedBinaryTree<E> t2)
			throws IllegalArgumentException {

		// TODO: Your implementation of this method starts here
		Node<E> k = (Node<E>) errorCheck(p);
	    if (isInternal(p))
	      throw new IllegalArgumentException();
	    if (!t1.isEmpty()) {
	      Node<E> r1 = (Node<E>) errorCheck(t1.root());
	      k.setLeft(r1);
	      r1.setParent(k);
	    }
	    if (!t2.isEmpty()) {
	      Node<E> r2 = (Node<E>) errorCheck(t2.root());
	      k.setRight(r2);
	      r2.setParent(k);
	    }
	}
	
	/**
	 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
	 * preorder traversal algorithm to visit tree position or elements.
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		return new itr();
	}
	
	private class itr implements Iterator<E> {
        private final Queue<Position<E>> que;
        private final LinkedList<Position<E>> stack;

        public itr() {
            que = new LinkedList<Position<E>>();
            que.add(root);
            stack = (LinkedList<Position<E>>) que;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException("No more nodes remain to iterate");
            final Position<E> pos = stack.pop();
            
            Node<E> node = (Node<E>) pos;

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

            return node.element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Invalid operation for pre-order iterator.");
        }
    }
	

	/**
	 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
	 * preorder traversal algorithm to visit tree position or elements.
	 */
	
	@Override
	public Iterable<Position<E>> positions() {
		// TODO: Your implementation of this method starts here
		Queue<Position<E>> positions = new LinkedList<Position<E>>();
	    if(size != 0)
	      preorderPositions(root(), (LinkedList<Position<E>>) positions);
	    return positions;
	}
	protected void preorderPositions(Position<E> v, LinkedList<Position<E>> p) throws IllegalArgumentException {
		p.addLast(v);
		if (left(v) != null)
			preorderPositions(left(v), p);
		if (right(v) != null)
			preorderPositions(right(v), p);
	}
	
	protected Position<E> errorCheck(Position<E> p) {
		if (p == null || !(p instanceof Position))
			throw new IllegalArgumentException();
		return (Position<E>) p;
	}
	 
}
