package sort;

/**
 * 时间复杂度0(n^2)
 */
public class SelectionSort {

	public static void main(String[] args) {
		Integer[] arr = { 1, 5, 67, 8, 3 };
		// selectionSort(arr, 5);// 循环实现
		selectionSort(arr, 0, 5);// 递归实现
		display(arr, 0, 5);
	}

	private static <T extends Comparable<? super T>> void selectionSort(
			T[] arr, int first, int last) {
		if (first < last) {
			int smallestIndex = getSmallestIndex(arr, first, last);
			swap(arr, first, smallestIndex);
			selectionSort(arr, first + 1, last);
		}
	}

	private static void selectionSort(Integer[] arr, int n) {
		if (n < 0 || n > arr.length) {
			throw new RuntimeException("IndexOutOfBound");
		}
		for (int index = 0; index < n; index++) {
			int smallestIndex = getSmallestIndex(arr, index, n);
			swap(arr, index, smallestIndex);
		}
	}

	private static <T> void swap(T[] arr, int index, int smallestIndex) {
		T temp = arr[index];
		arr[index] = arr[smallestIndex];
		arr[smallestIndex] = temp;
	}

	private static <T extends Comparable<? super T>> int getSmallestIndex(
			T[] arr, int first, int last) {
		int smallestIndex = first;
		T min = arr[smallestIndex];
		for (int i = first + 1; i < last; i++) {
			if (min.compareTo(arr[i]) > 0) {
				smallestIndex = i;
				min = arr[i];
			}
		}
		return smallestIndex;
	}

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
