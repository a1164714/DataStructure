package tree.binarytree.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import stack.IStack;
import stack.linkedstack.LinkedStack;
import tree.binarytree.binaryinterface.IBinaryNode;

public class PostOrderIterator<T> implements Iterator<T> {
	private IStack<IBinaryNode<T>> nodeStack;
	private IBinaryNode<T> currentNode;
	private static Set<IBinaryNode> set = new HashSet<IBinaryNode>();

	public PostOrderIterator(IBinaryNode<T> root) {
		nodeStack = new LinkedStack<IBinaryNode<T>>();
		currentNode = root;
		nodeStack.push(root);
	}

	@Override
	public boolean hasNext() {
		return !nodeStack.isEmpty();
	}

	@Override
	public T next() {
		while (!nodeStack.isEmpty()) {
			IBinaryNode<T> tmp = nodeStack.peek();
			if (tmp.getLeftChild() != null && !set.contains(tmp.getLeftChild())) {
				tmp = tmp.getLeftChild();
				nodeStack.push(tmp);
				continue;
			}
			if (tmp.getRightChild() != null
					&& !set.contains(tmp.getRightChild())) {
				nodeStack.push(tmp.getRightChild());
				continue;
			}
			set.add(nodeStack.peek());
			return nodeStack.pop().getData();
		}
		return null;
	}

}
