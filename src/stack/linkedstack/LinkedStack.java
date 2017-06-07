package stack.linkedstack;

import java.util.EmptyStackException;

import stack.IStack;

public class LinkedStack<T> implements IStack<T> {

	private Node topNode;

	public LinkedStack() {
		topNode = null;
	}

	private class Node {
		private T data;
		private Node next;

		private Node(T dataPortion) {
			this(dataPortion, null);
		}

		private Node(T dataPortion, Node linkPortion) {
			data = dataPortion;
			next = linkPortion;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}

	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}

	@Override
	public T pop() {
		T data = topNode.getData();
		topNode = topNode.getNextNode();
		return data;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return topNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public void clear() {
		topNode = null;
	}
}
