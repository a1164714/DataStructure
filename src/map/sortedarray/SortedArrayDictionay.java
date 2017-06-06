package map.sortedarray;

import java.util.Arrays;
import java.util.Iterator;

import map.IDictionary;

public class SortedArrayDictionay<K extends Comparable<? super K>, V>
		implements IDictionary<K, V> {

	private Entry<K, V>[] dictionary;
	private int currentSize;
	private static final int DEFAULT_SIZE = 16;

	public SortedArrayDictionay() {
		this(DEFAULT_SIZE);
	}

	public SortedArrayDictionay(int initialSize) {
		currentSize = 0;
		dictionary = new Entry[initialSize];
	}

	private class Entry<K, V> {

		@Override
		public String toString() {
			return "Entry [key=" + key + ", value=" + value + "]";
		}

		private K key;
		private V value;

		public Entry() {
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	private boolean isFull() {
		if (currentSize == dictionary.length) {
			return true;
		}
		return false;
	}

	/** 返回该key的索引值，无则返回要插入的位置 **/
	private int locateIndex(K key) {
		int index = 0;
		while (index < currentSize
				&& key.compareTo(dictionary[index].getKey()) > 0) {
			index++;
		}
		return index;
	}

	private void ensureCapacity() {
		if (isFull()) {
			dictionary = Arrays.copyOf(dictionary, currentSize * 2);
		}
	}

	/** 为该索引腾出空间 **/
	private void makeRoom(int keyIndex) {
		if (keyIndex == 0) {
			return;
		}
		int length = currentSize;
		while (keyIndex < length) {
			dictionary[length] = dictionary[--length];
		}
	}

	@Override
	public V add(K key, V value) {
		int keyIndex = locateIndex(key);
		V result = null;
		if (keyIndex < currentSize && key.equals(dictionary[keyIndex].getKey())) {
			result = dictionary[keyIndex].getValue();
			dictionary[keyIndex].setValue(value);
		} else {
			ensureCapacity();
			makeRoom(keyIndex);
			dictionary[keyIndex] = new Entry<K, V>(key, value);
			currentSize++;
		}
		return result;
	}

	@Override
	public V remove(K key) {
		int keyIndex = locateIndex(key);
		if (keyIndex >= currentSize || keyIndex < 0) {
			return null;
		}
		V result = dictionary[keyIndex].getValue();
		while (keyIndex < currentSize) {
			dictionary[keyIndex] = dictionary[++keyIndex];
		}
		currentSize--;
		return result;
	}

	@Override
	public V getValue(K key) {
		int keyIndex = locateIndex(key);
		if (keyIndex >= currentSize
				|| !key.equals(dictionary[keyIndex].getKey())) {
			return null;
		}
		return dictionary[keyIndex].getValue();
	}

	@Override
	public boolean contains(K key) {
		int keyIndex = locateIndex(key);
		if (keyIndex < currentSize && dictionary[keyIndex].getKey().equals(key)) {
			return true;
		}
		return false;
	}

	private class ValueIterator<V> implements Iterator<V> {
		boolean wasNextCalled;
		int currentPositon;

		public ValueIterator() {
			currentPositon = 0;
			wasNextCalled = false;
		}

		@Override
		public boolean hasNext() {
			if (currentPositon < currentSize) {
				return true;
			}
			return false;
		}

		@Override
		public V next() {
			if (hasNext()) {
				wasNextCalled = true;
				return (V) dictionary[currentPositon++].getValue();
			}
			return null;
		}
	}

	private class KeyIterator<K> implements Iterator<K> {
		boolean wasNextCalled;
		int currentPositon;

		public KeyIterator() {
			currentPositon = 0;
			wasNextCalled = false;
		}

		@Override
		public boolean hasNext() {
			if (currentPositon < currentSize) {
				return true;
			}
			return false;
		}

		@Override
		public K next() {
			if (hasNext()) {
				wasNextCalled = true;
				return (K) dictionary[currentPositon++].getKey();
			}
			return null;
		}
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return new KeyIterator<K>();
	}

	@Override
	public Iterator<V> getValueIterator() {
		return new ValueIterator<V>();
	}

	@Override
	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getSize() {
		return currentSize;
	}

	@Override
	public void clear() {
		currentSize = 0;
	}

}
