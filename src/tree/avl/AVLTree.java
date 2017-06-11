package tree.avl;

import tree.binarysearchtree.BinarySearchTree;
import tree.binarysearchtree.IBinarySearchTree;
import tree.binarytree.BinaryNode;
import tree.binarytree.binaryinterface.IBinaryNode;

/**
 * JDK中的TreeMap使用AVL实现
 * 
 * @param <T>
 */
public class AVLTree<T extends Comparable<? super T>> extends
		BinarySearchTree<T> implements IBinarySearchTree<T> {
	public AVLTree() {
		super();
	}

	public AVLTree(T rootEntry) {
		super(rootEntry);
	}

	@Override
	public T add(T newEntry) {
		T result = null;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			IBinaryNode<T> rootNode = getRootNode();
			result = addEntry(rootNode, newEntry);
			setRootNode(rebalance(rootNode));
		}
		return result;
	}

	private T addEntry(IBinaryNode<T> rootNode, T newEntry) {
		T result = null;
		if (newEntry.compareTo(rootNode.getData()) == 0) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		} else if (newEntry.compareTo(rootNode.getData()) < 0) {
			if (rootNode.hasLeftChild()) {
				IBinaryNode<T> leftChild = rootNode.getLeftChild();
				result = addEntry(leftChild, newEntry);
				rootNode.setLeftChild(rebalance(leftChild));
			} else {
				rootNode.setLeftChild(new BinaryNode<T>(newEntry));
			}
		} else {
			if (rootNode.hasRightChild()) {
				IBinaryNode<T> rightChild = rootNode.getRightChild();
				result = addEntry(rightChild, newEntry);
				rootNode.setRightChild(rebalance(rightChild));
			} else {
				rootNode.setRightChild(new BinaryNode<T>(newEntry));
			}
		}
		return result;
	}

	private IBinaryNode<T> rebalance(IBinaryNode<T> rootNode) {
		int heightDiff = getHeightDifference(rootNode);
		if (heightDiff > 1) {// 左树高度比右树高度大于1
			if (getHeightDifference(rootNode.getLeftChild()) > 0) {
				rootNode = rotateRight(rootNode);
			} else {
				rootNode = rotateLeftRight(rootNode);
			}
		} else if (heightDiff < -1) {// 右树高度比左树高度大于1
			if (getHeightDifference(rootNode.getRightChild()) < 0) {
				rootNode = rotateLeft(rootNode);
			} else {
				rootNode = rotateRightLeft(rootNode);
			}
		}
		return rootNode;
	}

	// 先右旋再左旋
	private IBinaryNode<T> rotateRightLeft(IBinaryNode<T> rootNode) {
		IBinaryNode<T> rightChild = rootNode.getLeftChild();
		rootNode.setRightChild(rotateRight(rightChild));// leftChlid进行右旋
		return rotateLeft(rootNode);// root进行左旋
	}

	// 先左旋再右旋
	private IBinaryNode<T> rotateLeftRight(IBinaryNode<T> rootNode) {
		IBinaryNode<T> leftChild = rootNode.getRightChild();
		rootNode.setLeftChild(rotateLeft(leftChild));// leftChlid进行左旋
		return rotateRight(rootNode);// root进行右旋
	}

	// 左旋
	private IBinaryNode<T> rotateLeft(IBinaryNode<T> rootNode) {
		IBinaryNode<T> rightChild = rootNode.getRightChild();
		rootNode.setRightChild(rightChild.getLeftChild());
		rightChild.setLeftChild(rootNode);
		return rightChild;
	}

	// 右旋
	private IBinaryNode<T> rotateRight(IBinaryNode<T> rootNode) {
		IBinaryNode<T> leftChild = rootNode.getLeftChild();
		rootNode.setLeftChild(leftChild.getRightChild());
		leftChild.setRightChild(rootNode);
		return leftChild;
	}

	private int getHeightDifference(IBinaryNode<T> rootNode) {
		int leftHeight = 0;
		int rightHeight = 0;
		if (rootNode.hasLeftChild()) {
			leftHeight = rootNode.getLeftChild().getHeight();
		}
		if (rootNode.hasRightChild()) {
			rightHeight = rootNode.getRightChild().getHeight();
		}
		return leftHeight - rightHeight;
	}
}
