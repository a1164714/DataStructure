package queue.queue.array;

import queue.queue.IQueue;

public class ArrayQueue<T> implements IQueue<T> {

	private T[] queue;
	private int frontIndex;
	private int endIndex;
	private static final int DEFAULT_CAPACITY = 4;

	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayQueue(int initCapacity) {
		queue = (T[]) new Object[initCapacity + 1];
		frontIndex = 0;
		endIndex = initCapacity;
	}

	@Override
	public void enqueue(T newEntry) {
		ensureCapacity();
		endIndex = (endIndex + 1) % queue.length;
		queue[endIndex] = newEntry;
	}

	private void ensureCapacity() {
		if (frontIndex == ((endIndex + 2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for (int index = 0; index < oldSize - 1; index++) {
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			endIndex = oldSize - 2;
		}
	}

	@Override
	public T dequeue() {
		if (!isEmpty()) {
			T t = queue[frontIndex];
			frontIndex = (frontIndex + 1) % queue.length;
			return t;
		}
		throw new RuntimeException("EmptyQueueException");
	}

	@Override
	public T getFront() {
		if (!isEmpty()) {
			return queue[frontIndex];
		}
		throw new RuntimeException("EmptyQueueException");
	}

	@Override
	public boolean isEmpty() {
		if (frontIndex == (endIndex + 1) % queue.length) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		frontIndex = (endIndex + 1) % queue.length;
	}

}
