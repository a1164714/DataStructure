package iterator.separateiterator;

import iterator.IIteraotr;
import linearlist.IList;

public class SeparateIterator<T> implements IIteraotr<T> {
	private boolean wasNextCalled;
	private int currentPosition;
	private IList<T> list;

	public SeparateIterator(IList<T> list) {
		this.wasNextCalled = false;
		this.currentPosition = -1;
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return currentPosition < list.getLength() - 1;
	}

	@Override
	public T next() {
		if (hasNext()) {
			currentPosition++;
			wasNextCalled = true;
			return list.getEntry(currentPosition);
		}
		throw new RuntimeException("Don't have next elemnts!");
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
