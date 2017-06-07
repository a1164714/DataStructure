package iterator;

public interface IIteraotr<T> {
	boolean hasNext();

	T next();

	void remove();
}
