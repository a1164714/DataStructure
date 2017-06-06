package search.array;

public class TestLinearList {
	public static void main(String[] args) {
		SortArrayList<String> list = new SortArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("bcd");
		list.add("cdd");
		System.out.println("contains:" + list.contains("bcd"));
		list.display();
	}
}
