package hash;

import java.util.Iterator;

public class TestHashDictionary {
	public static void main(String[] args) {
		HashedDictionary<String, String> map = new HashedDictionary<String, String>(3);
		map.add("1", "1");
		map.add("3", "3");
		map.add("4", "4");
		Iterator<String> keyIterator = map.getKeyIterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			System.out.println("key:"+key+",value:"+map.getValue(key));
		}
		System.out.println("getValue(3):"+map.getValue("3"));
		System.out.println("contain(3):"+map.contains("3"));
		map.remove("3"); 
		map.add("2", "2");
		map.remove("2");
		System.out.println("remove(3) ============>");
		Iterator<String> keyIterator1 = map.getKeyIterator();
		while (keyIterator1.hasNext()) {
			String key = keyIterator1.next();
			System.out.println("key:"+key+",value:"+map.getValue(key));
		}
		map.clear();
		System.out.println("clear() ==========>");
		System.out.println("isEmpty():"+map.isEmpty());
	}
}

