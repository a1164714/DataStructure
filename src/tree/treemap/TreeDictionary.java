package tree.treemap;

import java.util.Iterator;

import tree.binarysearchtree.BinarySearchTree;
import tree.binarysearchtree.IBinarySearchTree;
import map.IDictionary;

public class TreeDictionary<K extends Comparable<? super K>, V> implements
		IDictionary<K, V> {

	private IBinarySearchTree<Entry<K, V>> bst;

	public TreeDictionary() {
		bst = new BinarySearchTree<Entry<K, V>>();
	}

	private class Entry<S extends Comparable<? super S>, T> implements
			Comparable<Entry<S, T>> {
		private S key;
		private T value;

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object o) {
			boolean flag = false;
			try {
				flag = (((Entry<S, T>) o).key).equals(key);
			} catch (Exception e) {
				return false;
			}
			return flag;
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

		private Entry() {
			key = null;
			value = null;
		}

		private Entry(S key, T value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Entry<S, T> o) {
			return key.compareTo(o.key);
		}
	}

	@Override
	public V add(K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		Entry<K, V> returnEntry = bst.add(newEntry);
		if (returnEntry != null) {
			return returnEntry.getValue();
		}
		return null;
	}

	@Override
	public V remove(K key) {
		Entry<K, V> anEntry = new Entry<K, V>(key, null);
		Entry<K, V> returnEntry = bst.remove(anEntry);
		if (returnEntry != null) {
			return returnEntry.getValue();
		}
		return null;
	}

	@Override
	public V getValue(K key) {
		Entry<K, V> entry = new Entry<K, V>(key, null);
		Entry<K, V> anEntry = bst.getEntry(entry);
		if (anEntry != null) {
			return anEntry.getValue();
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return bst.contain(new Entry<K, V>(key, null));
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	private class KeyIterator implements Iterator<K> {
		private Iterator<Entry<K, V>> localIterator;

		public KeyIterator() {
			localIterator = bst.getInorderIterator();
		}

		@Override
		public boolean hasNext() {
			return localIterator.hasNext();
		}

		@Override
		public K next() {
			Entry<K, V> next = localIterator.next();
			if (next != null) {
				return next.getKey();
			}
			throw new RuntimeException("IndexOutOfBound");
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
		return bst.isEmpty();
	}

	@Override
	public int getSize() {
		return bst.getNumberOfNodes();
	}

	@Override
	public void clear() {
		bst.clear();
	}

}
