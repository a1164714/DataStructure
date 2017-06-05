package sort;

/**
 * O(n*logn)
 */
public class MergeSort {
	public static void main(String[] args) {
		Integer[] arr = { 1, 5, 67, 8, 3 };
		mergeSort(arr);
		display(arr, 0, 5);
	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] arr,
			int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static <T extends Comparable<? super T>> void merge(T[] arr,
			int left, int mid, int right) {
		@SuppressWarnings("unchecked")
		T[] tmpArr = (T[]) new Comparable<?>[arr.length];
		int left1 = left;
		int right1 = mid;
		int left2 = mid + 1;
		int right2 = right;
		int index = left;
		while ((left1 <= right1) && (left2 <= right2)) {
			if (arr[left1].compareTo(arr[left2]) < 0) {
				tmpArr[index++] = arr[left1++];
			} else {
				tmpArr[index++] = arr[left2++];
			}
		}
		while (left1 <= right1) {
			tmpArr[index++] = arr[left1++];
		}
		while (left2 <= right2) {
			tmpArr[index++] = arr[left2++];
		}
		for (int i = left; i <= right; i++) {
			arr[i] = tmpArr[i];
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
