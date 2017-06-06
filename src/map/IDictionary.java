package map;

import java.util.Iterator;

public interface IDictionary<K, V> {

	V add(K key, V value);

	V remove(K key);

	V getValue(K key);

	boolean contains(K key);

	Iterator<K> getKeyIterator();

	Iterator<V> getValueIterator();

	boolean isEmpty();

	int getSize();

	void clear();
}
