package tree.binarytree.iterator;

import java.util.Iterator;

import queue.queue.IQueue;
import queue.queue.linked.LinkedQueue;
import tree.binarytree.binaryinterface.IBinaryNode;

public class LevelOrderIterator<T> implements Iterator<T> {
	private IQueue<IBinaryNode<T>> queue;
	private IBinaryNode<T> root;

	public LevelOrderIterator(IBinaryNode<T> root) {
		queue = new LinkedQueue<IBinaryNode<T>>();
		this.root = root;
		queue.enqueue(root);
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public T next() {
		IBinaryNode<T> node = queue.dequeue();
		T t = node.getData();
		if (node.getLeftChild() != null) {
			queue.enqueue(node.getLeftChild());
		}
		if (node.getRightChild() != null) {
			queue.enqueue(node.getRightChild());
		}
		return t;
	}
}
