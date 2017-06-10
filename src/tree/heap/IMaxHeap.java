package tree.heap;

public interface IMaxHeap<T extends Comparable<? super T>> {
	void add(T newEntry);

	T removeMax();

	T getMax();

	boolean isEmpty();

	int getSize();

	void clear();
}
