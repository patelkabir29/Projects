package lab78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The YorkBinarySearchTree tree is an binary search tree 
 * 
 * 
 * In a YorkBinarySearchTree tree extends YorkLinkedBinaryTree 
 * and adopts same  convention in which we set a node
 * parent pointer to itself when removed from a tree to recognize it as an
 * invalid position later on. Thus, in your implementation for the
 * YorkLinkedBinaryTree tree, you must validate the received input position
 * every time to ensure that it is a valid tree node.
 * 
 * Note: You are responsible for creating and running the tests necessary to ensure 
 * that you have correct implementation of YorkBinarySearchTree tree. 
 * 
 *
 */
public class YorkBinarySearchTree<E extends Comparable<E>> extends YorkLinkedBinaryTree<E> {

	
	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkLinkedBinaryTree 
	 */
	
	/**
	 *  Constructs an empty binary search tree.
	 */
	public YorkBinarySearchTree() {
		// TODO: Your implementation of this method starts here
		this.setRoot(null);
	}
	
	/**
	 *  Constructs a binary search tree with given element at root 
	 */
	public YorkBinarySearchTree(E e) {
		// TODO: Your implementation of this method starts here
		this.addRoot(e);
	}
	
	/**
	 * 
	 * @param objects array of element to be added into this tree 
	 */
	
	public YorkBinarySearchTree(E[] objects) {
		// TODO: Your implementation of this method starts here
		for(E e: objects)
			this.insert(e);
		
	}
	
	/**
	 * Search of element inside the tree 
	 * if the element is found, then return the position of the element 
	 * if the element  is not found, return null 
	 * @param e  input element 
	 * @return  position of element if element exist inside the tree or null if element not exist
	 */
	
	public Position<E> search(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> tmp = (searchRecursive((Node<E>) root(), e)); 
        if (tmp != null)
            return tmp;
        else
            return null;
	}
	private Node<E> searchRecursive(Node<E> root, E e)  { 
        if (root==null || root.getElement().compareTo(e)==0) 
            return root; 
        if (root.getElement().compareTo(e) > 0) 
            return searchRecursive(root.getLeft(), e); 
        return searchRecursive(root.getRight(), e); 
    } 
	
	/**
	 * Remove element e from tree.
	 * if the element is found, remove its position and  return the position of its parent 
	 * if the element  is not found, return null
	 *  
	 * 
	 * @param e the input element for remove  
	 * @return  parent position of the  removed element or null 
	 */
	
	public Position<E> remove (E e){
		// TODO: Your implementation of this method starts here
		return deleteNode((Node<E>) this.root(), new Node<E>(e, null, null, null));
    }
	
	public Node<E> findMax(Node<E> root) {
        if (root.getRight() != null) {
            return findMax(root.getRight());
        } else {
            return root;
        }
    }
	private Node<E> deleteNode(Node<E> root, Node<E> node) {	
		if (root == null) {
            return null;
        } 
		else if (node.getElement().compareTo(root.getElement()) < 0 ) {
            root.setLeft(deleteNode(root.getLeft(), node));
        } 
		else if (node.getElement().compareTo(root.getElement()) > 0) {
            root.setRight(deleteNode(root.getRight(), node));
        } 
		else if(node.getElement().compareTo(root.getElement()) == 0){
            if (root.getLeft() != null && root.getRight() != null) {
                Node<E> max = findMax(root.getLeft());
                root.setElement(max.getElement());
                root.setLeft(deleteNode(root.getLeft(), max));
                return root;
            }
            else if (root.getLeft() != null) {
                return root.getLeft();
            }
            else if (root.getRight() != null) {
                return root.getRight();
            }
            else {
                return null;
            }
        }
        return root;
		
	}
	
	
	
	/**
	 * Adds the input  element to the binary search tree in 
	 * the appropriate position.  
	 * Note that equal elements are added to the right.
	 * @param e the element that will be added to binary search tree 
	 * @return the Position of the newly added element 
	 */
	public Position<E> insert(E e) {
		// TODO: Your implementation of this method starts here
		return insert((Node<E>) root(), e);
    }

    public Node<E> insert(Node<E> root, E e) {
        if (root == null) {
            this.addRoot(e);
            return root;
        }
        else if ((root.getElement().compareTo(e)) > 0) {
            root.setLeft(insert(root.getLeft(), e));
        } 
        else{
            root.setRight(insert(root.getRight(), e));
        }
        return root;
	}
	
	/**
	 * Returns true if the tree is a full binary tree
	 * @return  true if the tree is a full binary tree
	 */
	
	public boolean isFullBST() {
		// TODO: Your implementation of this method starts here
		return isFull((Node<E>) root());
	}
	
	public boolean isFull(Node<E> node) {
		if(this.isExternal(node)) {
			return true;
		}
		else if(node.getLeft()!=null && node.getRight()!=null){
			return isFull(node.getLeft()) && isFull(node.getRight());
		}
		else {
			return false;
		}
		
	}
	
	
	
	/**
	 * Returns the number of leaf nodes  
	 * @return Returns the number of leaf nodes 
	 */
	public int getNumberOfLeaves() {
		// TODO: Your implementation of this method starts here
		return numL((Node<E>) root());
	}
	private int numL(Node<E> node) {
		if(node == null) {
			return 0;
		}
		else if(node.getLeft()==null && node.getRight()==null) {
			return 1;
		}
		else{
			return numL(node.getLeft()) + numL(node.getRight());
		}
	}
	
	
	/**
	 * Returns the number of non-leaf nodes
	 * @return Returns the number of non-leaf nodes
	 */
	public int getNumberofNonLeaves() {
		// TODO: Your implementation of this method starts here
		return numNL((Node<E>) root());
	}
	
	private int numNL(Node<E> node) {
		if(node == null) {
			return 0;
		}
		else if(node.getLeft()==null && node.getRight()==null) {
			return 0;
		}
		else {
			return 1 + numNL(node.getLeft()) + numNL(node.getRight());
		}
	}
	
	/**
	 * Returns an iterable collection of positions of the tree, reported in inorder.
	 * @return  iterable collection of positions of the tree, reported in inorder
	 */
	public Iterable<Position<E>> inorder() {
		// TODO: Your implementation of this method starts here
		List<Position<E>> list = new ArrayList<Position<E>>();
		return inorderH((Node<E>) root(), (ArrayList<Position<E>>) list);
	}
	private Iterable<Position<E>> inorderH(Node<E> node,  ArrayList<Position<E>> list){
		
		if(node == null) {
			return null;
		}
		else {
			inorderH(node.getLeft(), list);
			list.add(node);
			inorderH(node.getRight(), list);
		}
		return list;
	}

	 
	
	/**
	 * Returns an iterable collection of positions of the tree, reported in preorder
	 * 
	 * @return iterable collection of positions of the tree, reported in preorder
	 */
	public Iterable<Position<E>> preorder() {
		// TODO: Your implementation of this method starts here
		List<Position<E>> list = new ArrayList<Position<E>>();
		return preorderH((Node<E>) root(), (ArrayList<Position<E>>) list);

	}
	private Iterable<Position<E>> preorderH(Node<E> node, ArrayList<Position<E>> list){
		
		if(node == null) {
			return null;
		}
		else {
			list.add(node);
			preorderH(node.getLeft(), list);
			preorderH(node.getRight(), list);
		}
		return list;
	}
	
	
	
	/**
	 * 
	 * Returns an iterable collection of positions of the tree, reported in postorder
	 * 
	 * @return iterable collection of positions of the tree, reported in postorder
	 */
	public Iterable<Position<E>> postorder() {
		// TODO: Your implementation of this method starts here
		List<Position<E>> list = new ArrayList<Position<E>>();
		return postorderH((Node<E>) root(), (ArrayList<Position<E>>) list);

	}
	private Iterable<Position<E>> postorderH(Node<E> node,  ArrayList<Position<E>> list){
		
		if(node == null) {
			return null;
		}
		else {
			postorderH(node.getLeft(), list);
			postorderH(node.getRight(), list);
			list.add(node);
		}
		return list;
	}

	
	/**
	 * Returns an iterable collection of positions of the tree in breadth-first
	 * order.
	 * @return iterable collection of positions of the tree in breadth-first order
	 */
	public Iterable<Position<E>> breadthfirst() {
		// TODO: Your implementation of this method starts here
		List<Position<E>> list = new ArrayList<Position<E>>();
		
		for(int i=0; i<=this.height(); i++) {
			list.add(breadthfirstH((Node<E>) root(), i));
		}
		
		return list;

	}
	private Node<E> breadthfirstH(Node<E> node, int h){
		
		if(node == null) {
			return null;
		}
		if(h == 0) {
			return node;
		}
		else {
			breadthfirstH(node.getLeft(), h-1);
			breadthfirstH(node.getRight(), h-1);
		}
		return null;
	}
	
	
	/**
	 * Overrides positions to make inorder the default order for binary trees.
	 */
	@Override
	public Iterable<Position<E>> positions() {
		// TODO: Your implementation of this method starts here
		 return this.inorder();
	}

	
}
