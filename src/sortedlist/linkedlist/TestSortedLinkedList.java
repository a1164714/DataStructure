package sortedlist.linkedlist;

public class TestSortedLinkedList {
	public static void main(String[] args) {
		SortedLinkedList<String> list = new SortedLinkedList<String>();
		list.add("abc");
		list.add("bcd");
		list.add("def");
		list.add("cdd");
		System.out.println("getEntry(2):"+list.getEntry(2));
		System.out.println("contain(cdd):"+list.contains("cdd"));
		System.out.println("getPostion(cdd):"+list.getPosition("cdd"));
		System.out.println("================");
		list.display();
		System.out.println("================");
		list.remove(1);
		list.remove("def");
//		list.clear();
		list.display();
		System.out.println("================");
	}
}
