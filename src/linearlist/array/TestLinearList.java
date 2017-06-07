package linearlist.array;

import org.junit.Test;

public class TestLinearList {

	@Test
	public void test1() {
		LinearList<Integer> list = new LinearList<Integer>(100);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("contain:" + list.contains(1));
		System.out.println("isFul:" + list.isFull());
		list.replace(1, 3);
		System.out.println("getEntry:" + list.getEntry(1));
		System.out.println("getLength:" + list.getLength());
		list.remove(1);
		list.add(1, 2);
		list.display();
		list.clear();
		System.out.println("list.clear()");
		System.out.println("isEmpty:" + list.isEmpty());
	}

	@Test
	// 测试自动扩容
	public void test2() {
		LinearList<Integer> list = new LinearList<Integer>(3);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.length());
		list.add(4);
		System.out.println(list.length());
	}
}
