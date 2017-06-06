package map.array;

import java.util.Iterator;

public class TestArrayDictionary {
	public static void main(String[] args) {
		ArrayDictionary<String,String> map = new ArrayDictionary<String, String>();
		map.add("1", "abc");
		map.add("2", "abc");
		map.add("3", "abc");
		map.add("2", "cde");
		Iterator<String> iterator = map.getKeyIterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println("key:"+key+",value:"+map.getValue(key));
		}
	}
}
 