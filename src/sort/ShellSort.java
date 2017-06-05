package sort;

/**
 * O(n^1.5)~O(n^2)
 */
public class ShellSort {

	public static void main(String[] args) {
		Integer[] arr = { 1, 5, 67, 8, 3 };
		sellSort(arr, 0, 5);
		display(arr, 0, 5);
	}

	private static <T extends Comparable<? super T>> void sellSort(T[] arr,
			int first, int last) {
		int n = last - first + 1;// 数组元素
		for (int space = n / 2; space > 0; space /= 2) {
			for (int begin = first; begin < first + space; begin++) {
				incrementalInsertionSort(arr, begin, last, space);
			}
		}
	}

	private static <T extends Comparable<? super T>> void incrementalInsertionSort(
			T[] arr, int begin, int end, int space) {
		int index;
		for (int unsorted = begin + space; unsorted < end; unsorted += space) {
			T firstUnsorted = arr[unsorted];
			for (index = unsorted - space; (index >= begin)
					&& firstUnsorted.compareTo(arr[index]) < 0; index -= space) {
				arr[index + space] = arr[index];
			}
			arr[index + space] = firstUnsorted;
		}
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
