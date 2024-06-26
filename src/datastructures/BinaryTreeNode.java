package datastructures;

/**
 * Class that offers the functionality of a generic binary tree node.
 * 
 * @param  <T>  the data type stored in the node
 * 
 * @author      Valentin Gabriel Mitrea
 */
public class BinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode<T> leftChild, rightChild;

	/**
	 * Constructor for a node in the binary tree.
	 * 
	 * @param  data  information that will be stored in the node
	 */
	public BinaryTreeNode(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	/**
	 * Constructor for a node in the binary tree that has child nodes.
	 * 
	 * @param  data        information that will be stored in the node
	 * @param  leftChild   the left child of the node
	 * @param  rightChild  the right child of the node
	 */
	public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	/**
	 * Adds a left child for this node.
	 * 
	 * @param  data  information that will be stored in the new node
	 * 
	 * @return       the new node
	 */
	public BinaryTreeNode<T> addLeftChild(T data) {
		leftChild = new BinaryTreeNode<T>(data);
		return leftChild;
	}

	/**
	 * Adds a right child for this node.
	 * 
	 * @param  data  information that will be stored in the new node
	 * 
	 * @return       the new node
	 */
	public BinaryTreeNode<T> addRightChild(T data) {
		rightChild = new BinaryTreeNode<T>(data);
		return rightChild;
	}

	/**
	 * Finds the node that contains the given information in the tree defined by this node and its children.
	 * 
	 * @param  data  the information to search for
	 * 
	 * @return       the node that contains the given information or null if not found
	 */
	public BinaryTreeNode<T> findNode(T data) {
		Queue<BinaryTreeNode<T>> nodes = new Queue<BinaryTreeNode<T>>();
		nodes.push(this);

		while (!nodes.isEmpty()) {
			BinaryTreeNode<T> node = nodes.pop();
			if (node.data == data)
				return node;

			if (node.leftChild != null)
				nodes.push(node.leftChild);
			if (node.rightChild != null)
				nodes.push(node.rightChild);
		}

		return null;
	}

	/**
	 * Checks if node is leaf.
	 * 
	 * @return  true if node is leaf, false otherwise
	 */
	public boolean isLeaf() {
		if (leftChild == null && rightChild == null)
			return true;

		return false;
	}

	/**
	 * Gets the information stored in the node.
	 * 
	 * @return  information stored in the node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the information stored in the node.
	 * 
	 * @param  data  new information to be stored in the node
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Gets the left child of the node.
	 * 
	 * @return  the left child of the node
	 */
	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Sets the left child of the node.
	 * 
	 * @param  leftChild  new left child of the node
	 */
	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Gets the right child of the node.
	 * 
	 * @return  the right child of the node
	 */
	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

	/**
	 * Sets the right child of the node.
	 * 
	 * @param  rightChild  new right child of the node
	 */
	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

}
