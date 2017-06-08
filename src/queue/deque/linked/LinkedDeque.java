package queue.deque.linked;

import queue.deque.IDeque;

public class LinkedDeque<T> implements IDeque<T> {

	private DNode firstNode;
	private DNode lastNode;

	public LinkedDeque() {
		firstNode = null;
		lastNode = null;
	}

	private class DNode {
		private T data;
		private DNode previous;
		private DNode next;

		public DNode() {
		}

		public DNode(T data, DNode previous, DNode next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}

		T getData() {
			return data;
		}

		void setData(T data) {
			this.data = data;
		}

		DNode getPrevious() {
			return previous;
		}

		void setPrevious(DNode previous) {
			this.previous = previous;
		}

		DNode getNext() {
			return next;
		}

		void setNext(DNode next) {
			this.next = next;
		}

	}

	@Override
	public void addToFront(T newEntry) {
		DNode dNode = new DNode(newEntry, null, null);
		if (isEmpty()) {
			lastNode = dNode;
		} else {
			dNode.setNext(firstNode);
			firstNode.setPrevious(dNode);
		}
		firstNode = dNode;
	}

	@Override
	public void addToBack(T newEntry) {
		DNode dNode = new DNode(newEntry, null, null);
		if (isEmpty()) {
			firstNode = dNode;
		} else {
			dNode.setPrevious(lastNode);
			lastNode.setNext(dNode);
		}
		lastNode = dNode;
	}

	@Override
	public T removeFront() {
		if (isEmpty()) {
			return null;
		}
		T t = firstNode.getData();
		firstNode = firstNode.getNext();
		if (firstNode == null) {
			lastNode = null;
		}else{
			firstNode.setPrevious(null);
		}
		return t;
	}

	@Override
	public T removeBack() {
		if (isEmpty()) {
			return null;
		}
		T t = lastNode.getData();
		lastNode = lastNode.getPrevious();
		if (lastNode == null) {
			firstNode  = null;
		}else{
			lastNode.setNext(null);
		}
		return t;
	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			return null;
		}
		return firstNode.getData();
	}

	@Override
	public T getBack() {
		if (isEmpty()) {
			return null;
		}
		return lastNode.getData();
	}

	@Override
	public boolean isEmpty() {
		if (firstNode == null) {
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
