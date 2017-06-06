package sortedlist;

/*
 * @Date:2017年6月5日 下午4:21:21
 * @Author:LinZF
 */
public interface ISortList<T extends Comparable<? super T>> {
	/**
	 * @Description:以适当的顺序向有序表插入新元素
	 * @param newEntry
	 * @return：boolean
	 */
	boolean add(T newEntry);

	/**
	 * @Description:删除指定元素
	 * @param newEntry
	 * @return：boolean
	 */
	boolean remove(T anEntry);

	/**
	 * @Description：获取一个元素的索引
	 * @param anEntry
	 * @return：int 索引值
	 */
	int getPosition(T anEntry);

	void remove(int givenPosition);

	void clear();

	boolean contains(T anEntry);

	/**
	 * @Title: getEntry
	 * @Description:获取目标索引的元素
	 * @param index
	 * @return 返回线性表改索引中的元素
	 * @return：T
	 * @Date:2017年5月31日 下午12:53:14
	 * @Author:LinZF
	 */
	T getEntry(int index);

	/** 获取长度 **/
	int getLength();

	/** 判断是否为空 **/
	boolean isEmpty();

	/** 将线性表内容输出 **/
	void display();

	/** 判断是否已满 **/
	boolean isFull();
}
