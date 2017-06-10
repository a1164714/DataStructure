package tree.heap.priorityqueue;

import queue.priorityqueue.IPriorityQueue;
import tree.heap.IMaxHeap;
import tree.heap.MaxHeap;

public class HeapPriorityQueue<T extends Comparable<? super T>> implements
		IPriorityQueue<T> {
	private IMaxHeap<T> pq;

	public HeapPriorityQueue() {
		pq = new MaxHeap<T>();
	}

	@Override
	public void add(T newEntry) {
		pq.add(newEntry);
	}

	@Override
	public T remove() {
		return pq.removeMax();
	}

	@Override
	public T peek() {
		return pq.getMax();
	}

	@Override
	public boolean isEmpty() {
		return pq.isEmpty();
	}

	@Override
	public int getSize() {
		return pq.getSize();
	}

	@Override
	public void clear() {
		pq.clear();
	}

}
