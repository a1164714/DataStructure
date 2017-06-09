package tree.binarytree.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import stack.IStack;
import stack.linkedstack.LinkedStack;
import tree.binarytree.binaryinterface.IBinaryNode;

public class PreOrderIterator<T> implements Iterator<T> {
	private IStack<IBinaryNode<T>> nodeStack;
	private IBinaryNode<T> currentNode;

	public PreOrderIterator(IBinaryNode<T> root) {
		nodeStack = new LinkedStack<IBinaryNode<T>>();
		currentNode = root;
	}

	@Override
	public boolean hasNext() {
		return !nodeStack.isEmpty() || currentNode != null;
	}

	@Override
	public T next() {
		IBinaryNode<T> rightNode = null;
		if (currentNode != null) {
			nodeStack.push(currentNode);
			rightNode = currentNode.getRightChild();
			currentNode = currentNode.getLeftChild();
		}
		T t = nodeStack.pop().getData();
		if (rightNode != null) {
			nodeStack.push(rightNode);
		}
		return t;
	}
	
	
	
}
