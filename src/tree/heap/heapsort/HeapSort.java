package tree.heap.heapsort;

public class HeapSort {
	public static void main(String[] args) {
		Integer[] heap = { 1, 4, 5, 2, 3 };
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
		heapSort(heap);
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	private static <T extends Comparable<? super T>> void heapSort(T[] heap) {
		for (int rootIndex = heap.length / 2 - 1; rootIndex >= 0; rootIndex--) {
			reheap(heap, rootIndex, heap.length - 1);// 初次建堆过程
		}
		swap(heap, 0, heap.length - 1);
		for (int lastIndex = heap.length - 2; lastIndex > 0; lastIndex--) {
			reheap(heap, 0, lastIndex);
			swap(heap, 0, lastIndex);
		}
	}

	private static <T> void swap(T[] array, int srcIndex, int desIndex) {
		T t = array[srcIndex];
		array[srcIndex] = array[desIndex];
		array[desIndex] = t;
	}

	private static <T extends Comparable<? super T>> void reheap(T[] heap,
			int rootIndex, int lastIndex) {
		T data = heap[rootIndex];
		int largerIndex = rootIndex * 2 + 1;// 索引从0开始了...
		while (largerIndex <= lastIndex) {
			int leftChildIndex = largerIndex;
			int rightChildIndex = leftChildIndex + 1;
			if (rightChildIndex <= lastIndex
					&& heap[rightChildIndex].compareTo(heap[leftChildIndex]) > 0) {
				largerIndex = rightChildIndex;
			}
			if (data.compareTo(heap[largerIndex]) < 0) {
				heap[rootIndex] = heap[largerIndex];
				rootIndex = largerIndex;
				largerIndex = rootIndex * 2 + 1;
			} else {
				break;
			}
		}
		heap[rootIndex] = data;
	}
}
