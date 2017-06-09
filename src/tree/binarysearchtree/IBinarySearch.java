package tree.binarysearchtree;

import java.util.Iterator;

import tree.ITree;

public interface IBinarySearch<T extends Comparable<? super T>> extends
		ITree<T> {
	/**
	 * @Title: contain
	 * @Description:在树中查找指定元素
	 * @param anEntry
	 *            待查找的对象
	 * @return 是否包含
	 * @return：boolean
	 * @Date:2017年6月9日 下午4:37:53
	 * @Author:LinZF
	 */
	boolean contain(T anEntry);

	/**
	 * @Title: getEntry
	 * @Description:从树中检索指定的元素
	 * @param anEntry
	 * @return：T
	 * @Date:2017年6月9日 下午4:39:00
	 * @Author:LinZF
	 */
	T getEntry(T anEntry);

	/**
	 * @Title: add
	 * @Description:将新元素插入树，如果该元素与树种已经存在的一个对象相匹配则用新元素替换（不允许重复）
	 * @param newEntry
	 * @return：T
	 * @Date:2017年6月9日 下午4:39:33
	 * @Author:LinZF
	 */
	T add(T newEntry);

	/**
	 * @Title: remove
	 * @Description: 从树中删除指定元素
	 * @param anEntry
	 * @return：T
	 * @Date:2017年6月9日 下午4:40:39
	 * @Author:LinZF
	 */
	T remove(T anEntry);

	/**
	 * @Title: getInorderIterator
	 * @Description: 获取中序遍历的迭代器
	 * @return：Iterator<T>
	 * @Date:2017年6月9日 下午4:41:15
	 * @Author:LinZF
	 */
	public Iterator<T> getInorderIterator();
}
