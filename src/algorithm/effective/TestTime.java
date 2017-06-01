package algorithm.effective;

/**
 * 算法复杂度：算法对空间和时间的需求，它是可以度量的。
 * 时间复杂度：算法执行所需的时间 。
 * 空间复杂度：算法执行所需的内存。
 * 算法分析：度量算法复杂度的过程。
 * 增长率函数：函数值与时间需求成正比。
 * 最坏情况时间：估计算法可能花费的最大执行时间。
 * 最佳情况时间：估计算法可能花费的最小执行时间。
 * 平均情况时间：
 */
public class TestTime {
	public static void main(String[] args) {
		System.out.println(multiple1(756200, 42300));
		System.out.println(multiple2(756200, 42300));
	}

	/**
	 * @Title: multiple
	 * @Description: 穷举法,756200*42300 = 756200+...+756200 //加42300次数
	 */
	//经过了g(n)=2n+1,O(n)
	public static long multiple1(long firstOperand, long secondOperand) {
		long startTime = System.nanoTime();
		long product = 0; // 1
		for (long counter = secondOperand; counter > 0; counter--) {
			product = product + firstOperand;//2n
		}
		long endTime = System.nanoTime();
		System.out.println("经历时间:" + (endTime - startTime));
		return product;
	}

	/**
	 * @Title: multiple2
	 * @Description:拆分法,756200*42300 = 756200*(40000+2000+300+00+0)
	 * 		  756200*1*0+765200*10*0+765200*100*3+...+756200*10000*4
	 */
	//
	public static long multiple2(long firstOperand, long secondOperand) {
		long startTime = System.nanoTime();
		long product = 0; // 1
		int length = String.valueOf(secondOperand).length(); //
		for (int i = 1; i <= length; i++) {
			int digit = (int) (secondOperand - (secondOperand / 10) * 10); // 4
			for (int j = digit; j > 0; j--) {
				product += firstOperand; // 2
			}
			secondOperand /= 10; // 2
			firstOperand *= 10; // 2
		}
		long endTime = System.nanoTime();
		System.out.println("经历时间:" + (endTime - startTime));
		return product;
	}

}
