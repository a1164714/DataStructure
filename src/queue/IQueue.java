package queue;

public interface IQueue<T> {
	/*
	 * 新元素插入队列后端
	 */
	void enqueue(T newEntry);

	/*
	 * 前端元素删除并返回
	 */
	T dequeue();

	/*
	 * 前端元素返回
	 */
	T getFront();

	boolean isEmpty();

	void clear();
}
