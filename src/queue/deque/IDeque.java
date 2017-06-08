package queue.deque;

public interface IDeque<T> {
	void addToFront(T newEntry);

	void addToBack(T newEntry);

	T removeFront();

	T removeBack();

	T getFront();

	T getBack();

	boolean isEmpty();

	void clear();
}
