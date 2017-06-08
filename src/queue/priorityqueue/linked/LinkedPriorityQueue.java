package queue.priorityqueue.linked;

import queue.priorityqueue.IPriorityQueue;

public class LinkedPriorityQueue<T extends Comparable<? super T>> implements
		IPriorityQueue<T> {

	private Node firstNode;
	private Node lastNode;

	public LinkedPriorityQueue() {
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
	public void add(T newEntry) {
		Node node = new Node(newEntry, null);
		if (isEmpty()) {
			firstNode = node;
			lastNode = node;
			return;
		}
		if (firstNode.getNext() == null) {
			if (node.getData().compareTo(firstNode.getData()) > 0) {
				lastNode.setNext(node);
				lastNode = node;
			} else {
				node.setNext(firstNode);
				firstNode = node;
			}
		} else {
			Node nextNode = firstNode;
			while (node.getData().compareTo(nextNode.getData()) > 0) {
				if (nextNode.getNext() != null
						&& node.getData().compareTo(
								nextNode.getNext().getData()) < 0) {
					break;
				}
				if (nextNode.getNext() == null) {
					lastNode.setNext(node);
					lastNode = node;
					return;
				}
				nextNode = nextNode.getNext();
			}
			Node next = nextNode.getNext();
			nextNode.setNext(node);
			node.setNext(next);
		}
	}

	@Override
	public T remove() {
		if (isEmpty()) {
			return null;
		}
		T data = firstNode.getData();
		firstNode = firstNode.getNext();
		return data;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		if (firstNode == null) {
			return true;
		}
		return false;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

}
