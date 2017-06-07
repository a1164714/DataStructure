package queue.linked;

import queue.IQueue;

public class LinkedQueue<T> implements IQueue<T> {

	private Node firstNode;
	private Node lastNode;

	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}

	private class Node {
		private T data;

		T getData() {
			return data;
		}

		Node getNext() {
			return next;
		}

		void setNext(Node next) {
			this.next = next;
		}

		private Node next;

		public Node(T data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	@Override
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		if (isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.setNext(newNode);
		}
		lastNode = newNode;
	}

	@Override
	public T dequeue() {
		if (!isEmpty()) {
			Node tmpNode = firstNode.getNext();
			T data = firstNode.getData();
			if (tmpNode == null) {
				firstNode = null;
				lastNode = null;
			} else {
				firstNode = tmpNode;
			}
			return data;
		}
		throw new RuntimeException("EmptyQueueException");
	}

	@Override
	public T getFront() {
		if (!isEmpty()) {
			return firstNode.getData();
		}
		throw new RuntimeException("EmptyQueueException");
	}

	@Override
	public boolean isEmpty() {
		if (lastNode == null) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

}
