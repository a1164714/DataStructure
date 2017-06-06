package map.sortedarray;

import java.util.Iterator;

public class TestArrayDictionary {
	public static void main(String[] args) {
		SortedArrayDictionay<String, String> map = new SortedArrayDictionay<String, String>();
		map.add("1", "a");
		map.add("2", "b");
		map.add("4", "d");
		map.add("2", "b");
		map.add("3", "c");
		map.add("4", "d");
		Iterator<String> iterator = map.getKeyIterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println("key:" + key + ",value:" + map.getValue(key));
		}
		map.remove("3");
		System.out.println("contain:"+map.contains("1"));
		System.out.println("getValue(2):"+map.getValue("2"));
		System.out.println("isEmpty:"+map.isEmpty());
		System.out.println("size:"+map.getSize());
		map.clear();
		System.out.println("contain:"+map.contains("1"));
		System.out.println("getValue(2):"+map.getValue("2"));
		System.out.println("isEmpty:"+map.isEmpty());
		System.out.println("size:"+map.getSize());
		Iterator<String> iterator1 = map.getKeyIterator();
		while (iterator1.hasNext()) {
			String key = iterator1.next();
			System.out.println("key:" + key + ",value:" + map.getValue(key));
		}
	}
}
