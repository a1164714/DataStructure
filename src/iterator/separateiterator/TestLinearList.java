package iterator.separateiterator;

import linearlist.linkedlist.LinearList;

import org.junit.Test;

public class TestLinearList {
	@Test
	public void test1(){
		LinearList<Integer> list = new LinearList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		SeparateIterator<Integer> iterator = new SeparateIterator<Integer>(list);
		while (iterator.hasNext()) {
			Integer i = iterator.next();
			System.out.println(i);
			iterator.remove();
		}
		System.out.println(list.getLength());
	}
}
