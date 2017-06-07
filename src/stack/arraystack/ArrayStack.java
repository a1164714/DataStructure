package stack.arraystack;

import java.util.Arrays;

import stack.IStack;

public class ArrayStack<T> implements IStack<T> {

	private T[] arr;
	private int stackSize;
	private static final int DEFAULT_CAPACITY = 4;

	public ArrayStack() {
		arr = (T[]) new Object[DEFAULT_CAPACITY];
		stackSize = 0;
	}

	@Override
	public void push(T newEntry) {
		ensureCapacity();
		arr[stackSize++] = newEntry;
	}

	private void ensureCapacity() {
		if (stackSize >= arr.length) {
			System.out.println("enlarge capacity");
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			return null;
		}
		return arr[--stackSize];
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return arr[stackSize - 1];
	}

	@Override
	public boolean isEmpty() {
		return stackSize == 0;
	}

	@Override
	public void clear() {
		stackSize = 0;
	}

}
