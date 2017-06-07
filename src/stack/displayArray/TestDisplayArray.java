package stack.displayArray;

public class TestDisplayArray {
	public static void main(String[] args) {
		LinearList<Integer> list = new LinearList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.stackDisplay(0, list.getLength() - 1);
	}
}
