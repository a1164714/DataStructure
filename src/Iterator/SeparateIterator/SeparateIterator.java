package Iterator.SeparateIterator;

import LinearList.LinkedList.ListInterface;

public class SeparateIterator<T> implements IteraotrInterface<T> {
	private boolean wasNextCalled;
	private int currentPosition;
	private ListInterface<T> list;

	public SeparateIterator(ListInterface<T> list) {
		this.wasNextCalled = false;
		this.currentPosition = -1;
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		if (currentPosition < list.getLength() - 1) {
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		if (currentPosition >= list.getLength() - 1) {
			throw new RuntimeException("Don't have next elemnts!");
		}
		currentPosition++;
		wasNextCalled = true;
		return list.getEntry(currentPosition);
	}

	@Override
	public void remove() {
		if (wasNextCalled) {
			list.remove(currentPosition);
			currentPosition--;
			wasNextCalled = false;
			return;
		}
		throw new RuntimeException("wasNextCalled isn't true");
	}

}
