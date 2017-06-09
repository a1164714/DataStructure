package tree.binarysearchtree;

import java.util.Iterator;

import tree.binarysearchtree.iterator.InorderIterator;
import tree.binarytree.BinaryNode;
import tree.binarytree.BinaryTree;
import tree.binarytree.binaryinterface.IBinaryNode;
import tree.binarytree.binaryinterface.IBinaryTree;

public class BinarySearchTree<T extends Comparable<? super T>> extends
		BinaryTree<T> implements IBinarySearch<T> {

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<>(rootEntry));
	}

	// 防止使用设置树方法
	@Override
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTree(T rootData, IBinaryTree<T> leftTree,
			IBinaryTree<T> rightTree) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contain(T anEntry) {
		return getEntry(anEntry) != null;
	}

	@Override
	public T getEntry(T anEntry) {
		return findEntry(getRootNode(), anEntry);
	}

	private T findEntry(IBinaryNode<T> rootNode, T anEntry) {
		T result = null;
		if (rootNode != null) {
			T rootEntry = rootNode.getData();
			if (rootEntry.equals(anEntry)) {
				result = rootEntry;
			} else if (anEntry.compareTo(rootEntry) < 0) {
				result = findEntry(rootNode.getLeftChild(), anEntry);
			} else {
				result = findEntry(rootNode.getRightChild(), anEntry);
			}
		}
		return result;
	}

	@Override
	public T add(T newEntry) {
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
			return null;
		} else {
			return addEntry(getRootNode(), newEntry);
		}
	}

	private T addEntry(IBinaryNode<T> rootNode, T newEntry) {
		T result = null;
		if (newEntry.compareTo(rootNode.getData()) == 0) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		} else if (newEntry.compareTo(rootNode.getData()) < 0) {
			if (rootNode.getLeftChild() != null) {
				result = addEntry(rootNode.getLeftChild(), newEntry);
			} else {
				rootNode.setLeftChild(new BinaryNode<T>(newEntry));
			}
		} else {
			if (rootNode.getRightChild() != null) {
				result = addEntry(rootNode.getRightChild(), newEntry);
			} else {
				rootNode.setRightChild(new BinaryNode<T>(newEntry));
			}
		}
		return result;
	}

	@Override
	public T remove(T anEntry) {
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator<T>(getRootNode());
	}

}
