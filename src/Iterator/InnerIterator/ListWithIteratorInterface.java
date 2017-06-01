package Iterator.InnerIterator;

import java.util.Iterator;

import LinearList.ListInterface;

public interface ListWithIteratorInterface<T> extends ListInterface<T> {
	Iterator<T> getIterator();
}
