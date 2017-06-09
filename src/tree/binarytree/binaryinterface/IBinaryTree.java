package tree.binarytree.binaryinterface;

import tree.ITree;
import tree.ITreeIterator;

public interface IBinaryTree<T> extends ITree<T>, ITreeIterator<T> {

	/**
	 * @Title: setTree
	 * @Description:将已有的二叉树置为一棵新的单节点的二叉树
	 * @param rootData
	 *            新树的根的数据
	 * @Date:2017年6月8日 下午4:35:57
	 * @Author:LinZF
	 */
	void setTree(T rootData);

	/**
	 * @Title: setTree
	 * @Description:将已有的二叉树置为一棵新的单节点的二叉树
	 * @param rootData
	 *            新树的根的数据
	 * @param leftTree
	 *            新树的左子树
	 * @param rightTree
	 *            新树的右子树
	 * @return：void
	 * @Date:2017年6月8日 下午4:37:50
	 * @Author:LinZF
	 */
	void setTree(T rootData, IBinaryTree<T> leftTree, IBinaryTree<T> rightTree);

}
