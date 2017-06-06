package map.array;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import map.IDictionary;

public class ArrayDictionary<K extends Comparable<? super K>, V> implements
		IDictionary<K, V> {

	private Entry<K, V>[] dictionary;
	private int currentSize;
	private static final int DEFAULT_SIZE = 16;

	public ArrayDictionary() {
		this(DEFAULT_SIZE);
	}

	public ArrayDictionary(int initialSize) {
		dictionary = new Entry[initialSize];
		currentSize = 0;
	}

	private class Entry<S, T> implements Serializable {
		private S key;
		private T value;

		public Entry() {
		}

		public Entry(S key, T value) {
			this.key = key;
			this.value = value;
		}

		public S getKey() {
			return key;
		}

		public void setKey(S key) {
			this.key = key;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

	}

	/** 判断内部数组是否已满 **/
	private boolean isFull() {
		if (currentSize == dictionary.length) {
			return true;
		}
		return false;
	}

	/** 为内部数组扩容 **/
	private void ensureCapacity() {
		if (isFull()) {
			dictionary = Arrays.copyOf(dictionary, currentSize * 2);
		}
	}

	/** 返回该key的索引值，无则返回要插入的位置 **/
	private int locateIndex(K key) {
		int index = 0;
		while (index < currentSize && !key.equals(dictionary[index].getKey())) {
			index++;
		}
		return index;
	}

	@Override
	public V add(K key, V value) {
		int keyIndex = locateIndex(key);
		V result = null;
		if (keyIndex < currentSize) {
			result = dictionary[keyIndex].getValue();
			dictionary[keyIndex].setValue(value);
		} else {
			ensureCapacity();
			dictionary[currentSize] = new Entry<K, V>(key, value);
			currentSize++;
		}
		return result;
	}

	@Override
	public V remove(K key) {
		V result = null;
		int keyIndex = locateIndex(key);
		if (keyIndex < currentSize) {
			result = dictionary[keyIndex].getValue();
			dictionary[keyIndex] = dictionary[currentSize - 1];
			currentSize--;
		}
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
