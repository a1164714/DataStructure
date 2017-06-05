package sortlist.linkedlist;

import sortlist.ISortList;

public class SortedLinkedList<T extends Comparable<? super T>> implements
		ISortList<T> {

	private Node firstNode;
	private int length;

	public SortedLinkedList() {
		firstNode = null;
		length = 0;
	}

	class Node {
		Node nextNode;
		T data;

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node() {
		}

		public Node(T value) {
			this.data = value;
		}

		public Node(T value, Node next) {
			this.data = value;
			this.nextNode = next;
		}
	}

	@Override
	public boolean add(T newEntry) {
		firstNode = add(newEntry, firstNode);
		length++;
		return true;
	}

	private Node add(T newEntry, Node currentNode) {
		if (currentNode == null
				|| newEntry.compareTo(currentNode.getData()) <= 0) {
			currentNode = new Node(newEntry, currentNode);
		} else {
			Node afterNode = add(newEntry, currentNode.getNextNode());// 递归
			currentNode.setNextNode(afterNode);
		}
		return currentNode;
	}

	@Override
	public boolean remove(T anEntry) {
		Node tmpNode = firstNode;
		Node beforeNode = null;
		int times = getLength();
		while (times > 0) {
			if (tmpNode.getData().equals(anEntry)) {
				length--;
				beforeNode.setNextNode(tmpNode.getNextNode());
				return true;
			}
			beforeNode = tmpNode;
			tmpNode = tmpNode.getNextNode();
			times--;
		}
		return false;
	}

	@Override
	public int getPosition(T anEntry) {
		Node tmpNode = firstNode;
		int times = getLength();
		while (times > 0) {
			if (tmpNode.getData().equals(anEntry)) {
				return times;
			}
			tmpNode = tmpNode.getNextNode();
			times--;
		}
		return -1;
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index > getLength()) {
			throw new RuntimeException("IndexOutOfBound");
		}
		length--;
		if (index == 0) {
			firstNode = firstNode.getNextNode();
			return;
		}
		Node nextNode = firstNode;
		Node beforeNode = null;
		while (index > 0) {
			beforeNode = nextNode;
			nextNode = nextNode.getNextNode();
			index--;
		}
		beforeNode.setNextNode(nextNode.getNextNode());
	}

	@Override
	public void clear() {
		length = 0;
		firstNode = null;
	}

	@Override
	public boolean contains(T anEntry) {
		Node tmpNode = firstNode;
		int times = getLength();
		while (times > 0) {
			if (tmpNode.getData().equals(anEntry)) {
				return true;
			}
			tmpNode = tmpNode.getNextNode();
			times--;
		}
		return false;
	}

	@Override
	public T getEntry(int index) {
		if (index < 0 || index > getLength()) {
			throw new RuntimeException("IndexOutOfBound");
		}
		Node nextNode = firstNode;
		while (index > 0) {
			nextNode = nextNode.getNextNode();
			index--;
		}
		return nextNode.getData();
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		if (getLength() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void display() {
		Node tmpNode = firstNode;
		int times = getLength();
		while (times > 0) {
			System.out.println(tmpNode.getData());
			tmpNode = tmpNode.getNextNode();
			times--;
		}
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
