package recursion.arrays;

public class TestLinearList {
	public static void main(String[] args) {
		LinearList<Integer> list = new LinearList<Integer>(100);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.display();
	}
}
