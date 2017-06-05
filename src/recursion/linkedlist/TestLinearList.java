package recursion.linkedlist;

import org.junit.Test;

public class TestLinearList {
	@Test
	public void test1(){
		LinearList<Integer> list = new LinearList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(3, 77);
		System.out.println("getEntry:"+list.getEntry(1));
		System.out.println("contains:"+list.contains(1));
		list.replace(2, 66);
		System.out.println("==========================");
		list.display();
		System.out.println("==========================");
		list.remove(1);
		list.display();
		System.out.println("==========================");
	}
}
