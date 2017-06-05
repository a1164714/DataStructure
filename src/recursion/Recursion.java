package recursion;

public class Recursion {
	public static void countDown(int i) {
		System.out.println(i);
		if (i > 1) {
			countDown(i - 1);
		}
	}

	public static int sum(int i) {
		int sum;
		if (i == 1) {
			sum = 1;
		} else {
			sum = sum(i - 1) + i;
		}
		return sum;
	}

	public static void main(String[] args) {
		countDown(10);
		System.out.println(sum(10));
	}
}
