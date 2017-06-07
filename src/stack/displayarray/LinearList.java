package stack.displayarray;

import linearlist.IList;
import stack.IStack;
import stack.arraystack.ArrayStack;

public class LinearList<T> implements IList<T> {

	private T[] arrs;
	private int length;
	private static final int INIT_SIZE = 10;

	private class Record {
		private int first, last;

		private Record(int first, int last) {
			this.first = first;
			this.last = last;
		}
	}

	// 测试用
	protected int length() {
		return arrs.length;
	}

	public LinearList() {
		this(INIT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public LinearList(int intSize) {
		length = 0;
		arrs = (T[]) new Object[intSize];
	}

	@Override
	public void add(T newEntry) {
		if (isFull()) {
			doubleArray();
		}
		arrs[length] = newEntry;
		length++;
	}

	@SuppressWarnings("unchecked")
	private void doubleArray() {
		T[] oldList = arrs;
		int oldSize = arrs.length;
		arrs = (T[]) new Object[oldSize * 2];
		for (int i = 0; i < oldList.length; i++) {
			arrs[i] = oldList[i];
		}
	}

	@Override
	public void add(int index, T newEntry) {
		if (isFull()) {
			doubleArray();
		}
		if (index < 0 || index >= getLength()) {
			throw new RuntimeException("indexOutOfBound");
		}
		for (int i = getLength(); i > index; i--) {
			arrs[i] = arrs[i - 1];
		}
		arrs[index] = newEntry;
		length++;
	}

	@Override
	public void remove(int index) {
		if (isEmpty()) {
			throw new RuntimeException("LinearList is Empty");
		}
		if (index < 0 || index >= getLength()) {
			throw new RuntimeException("indexOutOfBound");
		}
		for (int i = index; i < getLength(); i++) {
			arrs[i] = arrs[i + 1];
		}
		length--;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		if (isEmpty()) {
			throw new RuntimeException("LinearList is Empty");
		}
		arrs = (T[]) new Object[arrs.length];
		length = 0;
	}

	@Override
	public void replace(int index, T newEntry) {
		if (index < 0 || index >= getLength()) {
			throw new RuntimeException("indexOutOfBound");
		}
		arrs[index] = newEntry;
	}

	@Override
	public boolean contains(T anEntry) {
		for (int i = 0; i < getLength(); i++) {
			if (arrs[i] == anEntry) {
				return true;
			}
		}
		return false;
	}

	@Override
	public T getEntry(int index) {
		if (index < 0 || index > getLength()) {
			throw new RuntimeException("IndexOutOfBound");
		}
		return arrs[index];
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		if (getLength() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (getLength() == arrs.length) {
			return true;
		}
		return false;
	}

	@Override
	public void display() {
		if (isEmpty()) {
			System.out.println("LinearList is Empty!");
			return;
		}
		for (int i = 0; i < getLength(); i++) {
			System.out.println(arrs[i]);
		}
	}

	public void stackDisplay(int first, int last) {
		IStack<Record> programStack = new ArrayStack<Record>();
		programStack.push(new Record(first, last));
		while (!programStack.isEmpty()) {
			Record record = programStack.pop();
			first = record.first;
			last = record.last;
			if (first == last) {
				System.out.println(arrs[first]);
			} else {
				int mid = (last + first) / 2;
				programStack.push(new Record(mid + 1, last));
				programStack.push(new Record(first, mid));
			}
		}
	}
}
