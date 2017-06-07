package iterator.inneriterator.array;

import java.util.Iterator;

public class TestArrayList {
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
			iterator.remove();
		}
		System.out.println(list.getLength());
	}
}
