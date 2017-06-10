package tree.heap;

import java.util.Arrays;

import javax.swing.JEditorPane;

public class MaxHeap<T extends Comparable<? super T>> implements IMaxHeap<T> {
	private T[] heap;
	private int lastIndex;
	private static final int DEFAULT_CAPACITY = 5;

	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}

	public MaxHeap(T[] entries) {
		lastIndex = entries.length;
		heap = (T[]) new Comparable[lastIndex + 1];
		for (int index = 0; index < lastIndex; index++) {
			heap[index + 1] = entries[index];
		}
		// 创建堆
		for (int index = lastIndex / 2; index > 0; index--) {
			reheap(index);
		}
	}
	
	@SuppressWarnings("unchecked")
	public MaxHeap(int initialCapacity) {
		heap = (T[]) new Comparable[initialCapacity + 1];// 索引0空出来了
		lastIndex = 0;
	}

	@Override
	public void add(T newEntry) {
		lastIndex++;
		if (lastIndex >= heap.length) {
			doubleHeap();
		}
		int newIndex = lastIndex;
		int parentIndex = newIndex / 2;
		while (newIndex > 1 && newEntry.compareTo(heap[parentIndex]) > 0) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		}
		heap[newIndex] = newEntry;
	}

	private void doubleHeap() {
		heap = Arrays.copyOf(heap, heap.length * 2);
	}

	@Override
	public T removeMax() {
		T root = null;
		if (!isEmpty()) {
			root = heap[1];
			heap[1] = heap[lastIndex];
			lastIndex--;
			reheap(1);
		}
		return root;
	}

	// 对半堆进行重新建堆,O(n)
	private void reheap(int index) {
		T data = heap[index];
		int largerChildIndex = index * 2;
		while (largerChildIndex <= lastIndex) {
			int leftChildIndex = largerChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			if (rightChildIndex <= lastIndex
					&& heap[rightChildIndex].compareTo(heap[leftChildIndex]) > 0) {
				largerChildIndex = rightChildIndex;
			}
			if (data.compareTo(heap[largerChildIndex]) < 0) {
				heap[index] = heap[largerChildIndex];
				index = largerChildIndex;
				largerChildIndex = index * 2;
			} else {
				break;
			}
		}
		heap[index] = data;
	}

	@Override
	public T getMax() {
		return heap[1];
	}

	@Override
	public boolean isEmpty() {
		if (lastIndex < 1) {
			return true;
		}
		return false;
	}

	@Override
	public int getSize() {
		return lastIndex;
	}

	@Override
	public void clear() {
		for (; lastIndex > -1; lastIndex--) {
			heap[lastIndex] = null;
		}
		lastIndex = 0;
	}

}
