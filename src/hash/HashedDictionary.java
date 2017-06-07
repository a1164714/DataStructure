package hash;

import java.util.Iterator;
import java.util.NoSuchElementException;

import map.IDictionary;

public class HashedDictionary<K, V> implements IDictionary<K, V> {

	// The dictionary:
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 5;

	// The hash table:
	private TableEntry<K, V>[] hashTable;
	// hash table不能填充太满
	private static final double MAX_LOAD_FACTOR = 0.5;

	public HashedDictionary() {
		this(DEFAULT_CAPACITY);
	}

	public HashedDictionary(int initialCapacity) {
		numberOfEntries = 0;
		int tableSize = getNextPrime(initialCapacity);
		TableEntry<K, V>[] temp = (TableEntry<K, V>[]) new TableEntry[tableSize];
		hashTable = temp;
	}

	private int getNextPrime(int tableSize) {
		if (tableSize % 2 == 0) {
			tableSize++;
		}
		return tableSize;
	}

	private enum States {
		CURRENT, REMOVED
	}

	private class TableEntry<S, T> {
		private S key;
		private T value;
		private States state;

		private TableEntry(S searchKey, T dataValue) {
			key = searchKey;
			value = dataValue;
			state = States.CURRENT;
		}

		S getKey() {
			return key;
		}

		T getValue() {
			return value;
		}

		void setValue(T value) {
			this.value = value;
		}

		boolean isRemoved() {
			if (state.equals(States.REMOVED)) {
				return true;
			}
			return false;
		}

		void setToRemoved() {
			state = States.REMOVED;
		}

		void setToIn() {
			state = States.CURRENT;
		}

		boolean isIn() {
			if (state.equals(States.CURRENT)) {
				return true;
			}
			return false;
		}

	}

	@Override
	public V add(K key, V value) {
		if ((key == null) || (value == null))
			throw new IllegalArgumentException(
					"Cannot add null to a dictionary.");
		V oldValue; // value to return
		int index = getHashIndex(key);
		index = probe(index, key); // check for and resolve collision
		assert (index >= 0) && (index < hashTable.length);
		if ((hashTable[index] == null) || hashTable[index].isRemoved()) {
			hashTable[index] = new TableEntry<K, V>(key, value);
			hashTable[index].setToIn();
			numberOfEntries++;
			oldValue = null;
		} else { // key found; get old value for return and then replace it
			oldValue = hashTable[index].getValue();
			hashTable[index].setValue(value);
		}
		if (isHashTableTooFull())
			enlargeHashTable();
		return oldValue;
	}

	private void enlargeHashTable() {
		System.out.println("enlargeHashTable");
		TableEntry<K, V>[] oldTable = hashTable;
		int oldSize = hashTable.length;
		int newSize = getNextPrime(oldSize * 2);
		@SuppressWarnings("unchecked")
		TableEntry<K, V>[] temp = (TableEntry<K, V>[]) new TableEntry[newSize];
		hashTable = temp;
		numberOfEntries = 0;
		for (int index = 0; index < oldSize; index++) {
			if ((oldTable[index] != null) && oldTable[index].isIn())
				add(oldTable[index].getKey(), oldTable[index].getValue());
		}
	}

	private int probe(int index, K key) {
		boolean found = false;
		int removedStateIndex = -1; // Index of first location in removed state
		while (!found && (hashTable[index] != null)) {
			if (hashTable[index].isIn()) {
				if (key.equals(hashTable[index].getKey()))
					found = true; // Key found
				else
					index = (index + 1) % hashTable.length; // Linear probing
			} else {
				if (removedStateIndex == -1)
					removedStateIndex = index;
				index = (index + 1) % hashTable.length; // Linear probing
			}
		}
		if (found || (removedStateIndex == -1))
			return index;
		else
			return removedStateIndex;
	}

	private boolean isHashTableTooFull() {
		if (numberOfEntries >= Math.floor(hashTable.length * MAX_LOAD_FACTOR)) {
			return true;
		}
		return false;
	}

	@Override
	public V remove(K key) {
		V removedValue = null;
		int index = getHashIndex(key);
		index = locate(index, key);
		if (index != -1) {
			removedValue = hashTable[index].getValue();
			hashTable[index].setToRemoved();
			numberOfEntries--;
		}
		return removedValue;
	}

	@Override
	public V getValue(K key) {
		if (isEmpty()) {
			return null;
		}
		V result = null;
		int index = getHashIndex(key);
		index = locate(index, key);
		if (index != -1) {
			result = hashTable[index].getValue();
		}
		return result;
	}

	private int locate(int index, K key) {
		boolean found = false;
		while (!found && (hashTable[index] != null)) {
			if (hashTable[index].isIn()
					&& key.equals(hashTable[index].getKey()))
				found = true; // key found
			else
				index = (index + 1) % hashTable.length; // 线性探测法
		}
		int result = -1;
		if (found)
			result = index;
		return result;
	}

	/** 获取key值的hash值 **/
	private int getHashIndex(K key) {
		// 取出key的内存十进制值取length的余数，如果为负数加上length
		int hashIndex = key.hashCode() % hashTable.length;
		if (hashIndex < 0)
			hashIndex = hashIndex + hashTable.length;
		return hashIndex;
	}

	@Override
	public boolean contains(K key) {
		if (isEmpty()) {
			return false;
		}
		int index = getHashIndex(key);
		index = locate(index, key);
		if (index != -1) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	private class KeyIterator implements Iterator<K> {
		private int currentIndex; // Current position in hash table
		private int numberLeft; // Number of entries left in iteration

		private KeyIterator() {
			currentIndex = 0;
			numberLeft = numberOfEntries;
		}

		public boolean hasNext() {
			return numberLeft > 0;
		}

		public K next() {
			K result = null;
			if (hasNext()) {
				while ((hashTable[currentIndex] == null)
						|| hashTable[currentIndex].isRemoved()) {
					currentIndex++;
				}
				result = hashTable[currentIndex].getKey();
				numberLeft--;
				currentIndex++;
			} else
				throw new NoSuchElementException();

			return result;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<V> getValueIterator() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (numberOfEntries == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getSize() {
		return numberOfEntries;
	}

	@Override
	public void clear() {
		if (isEmpty()) {
			return;
		}
		numberOfEntries = 0;
	}

}
