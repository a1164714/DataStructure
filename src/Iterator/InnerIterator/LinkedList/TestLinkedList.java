package Iterator.InnerIterator.LinkedList;

import java.util.Iterator;

import Iterator.SeparateIterator.SeparateIterator;

public class TestLinkedList {
	public static void main(String[] args) {
		LinearList<Integer> list = new LinearList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Iterator<Integer> iterator = list.getIterator();
		while (iterator.hasNext()) {
			Integer i = iterator.next();
			System.out.println(i);
		}
		System.out.println(list.getLength());
	}
}
