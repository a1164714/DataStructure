package tree.binarytree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import stack.IStack;
import stack.linkedstack.LinkedStack;
import tree.binarytree.binaryinterface.IBinaryNode;

public class InOrderIterator<T> implements Iterator<T> {
	private IStack<IBinaryNode<T>> nodeStack;
	private IBinaryNode<T> currentNode;

	public InOrderIterator(IBinaryNode<T> root) {
		nodeStack = new LinkedStack<IBinaryNode<T>>();
		currentNode = root;
	}

	public InOrderIterator() {
		nodeStack = new LinkedStack<IBinaryNode<T>>();
		currentNode = null;
	}

	@Override
	public boolean hasNext() {
		if (currentNode != null || !nodeStack.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		IBinaryNode<T> nextNode = null;
		while (currentNode != null) {
			nodeStack.push(currentNode);
			currentNode = currentNode.getLeftChild();
		}
		// 访问最左结点，然后遍历它的右子树
		if (!nodeStack.isEmpty()) {
			nextNode = nodeStack.pop();
			currentNode = nextNode.getRightChild();
		} else {
			throw new NoSuchElementException();
		}
		return nextNode.getData();
	}

}
