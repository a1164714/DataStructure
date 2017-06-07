package linearlist.linkedlist;

import linearlist.IList;

public class LinearList<T> implements IList<T> {
	private Node node;
	private int length;

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

	public LinearList() {
		length = 0;
	}

	@Override
	public void add(T newEntry) {
		if (getLength() == 0) {
			node = new Node(newEntry);
			length++;
			return;
		}
		Node curNode = getNodeAt(getLength() - 1);
		curNode.setNextNode(new Node(newEntry));
		length++;
	}

	private Node getNodeAt(int index) {
		Node tmpNode = node;
		while (index > 0) {
			tmpNode = tmpNode.getNextNode();
			index--;
		}
		return tmpNode;
	}

	@Override
	public void add(int index, T newEntry) {
		if (index < 0 || index > getLength()) {
			throw new RuntimeException("IndexOutOfBound");
		}
		if (index == 0) {
			Node tmpNode = node;
			node = new Node(newEntry);
			node.setNextNode(tmpNode);
		} else {
			Node beforeNode = getNodeAt(index - 1);
			Node afterNode = beforeNode.getNextNode();
			Node currentNode = new Node(newEntry);
			beforeNode.setNextNode(currentNode);
			currentNode.setNextNode(afterNode);
		}
		length++;
	}

	@Override
	public void remove(int index) {
		if (isEmpty() || index < 0 || index > getLength()) {
			throw new RuntimeException("IndexOutOfBound");
		}
		if (index == 0) {
			node = node.getNextNode();
		} else {
			Node beforeNode = getNodeAt(index - 1);
			Node currentNode = beforeNode.getNextNode();
			beforeNode.setNextNode(currentNode.getNextNode());
		}
		length--;
	}

	@Override
	public void clear() {
		length = 0;
	}

	@Override
	public void replace(int index, T newEntry) {
		if (isEmpty() || index < 0 || index > getLength()) {
			throw new RuntimeException("IndexOutOfBound");
		}
		Node tmpNode = getNodeAt(index - 1);
		tmpNode.setData(newEntry);
	}

	@Override
	public boolean contains(T anEntry) {
		if (isEmpty()) {
			throw new RuntimeException("LinearList is Empty");
		}
		int times = getLength();
		Node tmpNode = node;
		while (times > 0) {
			if (tmpNode.getData() == anEntry) {
				return true;
			}
			tmpNode = tmpNode.getNextNode();
			times--;
		}
		return false;
	}

	@Override
	public T getEntry(int index) {
		if (isEmpty() || index < 0 || index > getLength()) {
			throw new RuntimeException("IndexOutOfBound");
		}
		Node tmpNode = getNodeAt(index);
		return tmpNode.getData();
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
		if (isEmpty()) {
			throw new RuntimeException("LinearList is Empty");
		}
		Node tmpNode = node;
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
