package iterator.inneriterator;

import java.util.Iterator;

import linearlist.IList;

public interface IListWithIterator<T> extends IList<T> {
	Iterator<T> getIterator();
}
