package sort;

public class QuickSort {
	public static void main(String[] args) {
		Integer[] arr = { 1, 5, 67, 8, 3 };
		quickSort(arr, 0, arr.length - 1);
		display(arr, 0, 5);
	}

	private static <T extends Comparable<? super T>> void quickSort(T[] arr,
			int start, int end) {
		if (start < end) {
			int i = start + 1;
			int j = end;
			T tmp = arr[start];
			while (true) {
				while (i <= end && arr[i].compareTo(tmp) < 0) {
					i++;
				}
				while (j > start && arr[j].compareTo(tmp) > 0) {
					j--;
				}
				if (i < j) {
					swap(arr, i, j);
				} else {
					break;
				}
			}
			swap(arr, start, j);
			quickSort(arr, start, j - 1);
			quickSort(arr, j + 1, end);
		}
	}

	private static <T> void swap(T[] arr, int i, int j) {
		T t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
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
