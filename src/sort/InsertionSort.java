package sort;

/**
 * O(n)~O(n^2) 越有序，做的工作越少
 */
public class InsertionSort {

	public static void main(String[] args) {
		Integer[] arr = { 1, 5, 67, 8, 3 };
		insertionSort(arr, 0, 5);
		insertionSortRecursion(arr, 0, 5); // 递归调用
		display(arr, 0, 5);
	}

	private static <T extends Comparable<? super T>> void insertionSortRecursion(
			T[] arr, int first, int last) {
		last = last - 1;
		if (first < last) {
			// 对除了最后一个元素之外的进行排序
			insertionSortRecursion(arr, first, last - 1);
			insertInOrder(arr[last], arr, first, last - 1);
		}
	}

	private static <T extends Comparable<? super T>> void insertionSort(
			T[] arr, int first, int last) {
		// 第一个元素为有序，则无序数组为first+1 - last
		for (int unsorted = first + 1; unsorted < last; unsorted++) {
			T firstUnsorted = arr[unsorted];
			insertInOrder(firstUnsorted, arr, first, unsorted - 1);
		}
	}

	private static <T extends Comparable<? super T>> void insertInOrder(
			T element, T[] arr, int begin, int end) {
		int index = end;
		while (index >= begin && element.compareTo(arr[index]) < 0) {
			arr[index + 1] = arr[index];
			index--;
		}
		arr[index + 1] = element;
	};

	private static void display(Integer[] arr, int first, int last) {
		if (first < 0 || last > arr.length) {
			throw new RuntimeException("IndexOutOfBound");
		}
		if (first < last) {
			display(arr, first, last - 1);
			System.out.println(arr[last - 1]);
		}
	}
}
