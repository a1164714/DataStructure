package tree;

import java.util.Iterator;

public interface ITreeIterator<T> {
	Iterator<T> getPreOrderIterator();

	Iterator<T> getPostOrderIterator();

	Iterator<T> getInOrderIterator();

	Iterator<T> getLevelOrderIterator();

}
