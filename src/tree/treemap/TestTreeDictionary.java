package tree.treemap;

import java.util.Iterator;

public class TestTreeDictionary {
	public static void main(String[] args) {
		TreeDictionary<String, String> map = new TreeDictionary<String, String>();
		map.add("a", "a");
		map.add("d", "d");
		map.add("b", "b");
		map.add("c", "c");
		map.add("f", "f");
		System.out.println("contain(a):"+map.contains("a"));
		System.out.println("getValue(a):"+map.getValue("a"));
		System.out.println("size:"+map.getSize());
//		map.clear();
		map.remove("b");
		Iterator<String> keyIterator = map.getKeyIterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			System.out.println("key:"+key+",value:"+map.getValue(key));
		}
	}
}
