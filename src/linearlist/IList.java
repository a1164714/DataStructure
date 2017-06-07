package linearlist;

public interface IList<T> {
	/**
	 * @Title: add
	 * @Description:往线性表末尾插入新元素
	 * @param newEntry
	 * @return 插入成功与否
	 * @return：boolean
	 * @Date:2017年5月31日 下午12:44:05
	 * @Author:LinZF
	 **/
	void add(T newEntry);

	void add(int index, T newEntry);

	void remove(int index);

	/** 清空线性表 **/
	void clear();

	/**
	 * @Title: replace
	 * @Description:0<=index<getLength()
	 * @param index
	 * @param newEntry
	 * @Date:2017年5月31日 下午12:44:48
	 * @Author:LinZF
	 **/
	void replace(int index, T newEntry);

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
