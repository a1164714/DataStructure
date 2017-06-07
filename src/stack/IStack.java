package stack;

public interface IStack<T> {

	void push(T newEntry);

	// remove and returns this stack's top entry
	T pop();

	// returns this stack's top entry
	T peek();

	boolean isEmpty();

	void clear();
}
