package tree.binarysearchtree;

import java.util.Iterator;

import tree.binarysearchtree.iterator.InorderIterator;
import tree.binarytree.BinaryNode;
import tree.binarytree.BinaryTree;
import tree.binarytree.binaryinterface.IBinaryNode;
import tree.binarytree.binaryinterface.IBinaryTree;

public class BinarySearchTree<T extends Comparable<? super T>> extends
		BinaryTree<T> implements IBinarySearchTree<T> {

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<>(rootEntry));
	}

	// 防止使用设置树方法
	@Override
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTree(T rootData, IBinaryTree<T> leftTree,
			IBinaryTree<T> rightTree) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contain(T anEntry) {
		return getEntry(anEntry) != null;
	}

	@Override
	public T getEntry(T anEntry) {
		return findEntry(getRootNode(), anEntry);
	}

	private T findEntry(IBinaryNode<T> rootNode, T anEntry) {
		T result = null;
		if (rootNode != null) {
			T rootEntry = rootNode.getData();
			if (rootEntry.equals(anEntry)) {
				result = rootEntry;
			} else if (anEntry.compareTo(rootEntry) < 0) {
				result = findEntry(rootNode.getLeftChild(), anEntry);
			} else {
				result = findEntry(rootNode.getRightChild(), anEntry);
			}
		}
		return result;
	}

	@Override
	public T add(T newEntry) {
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
			return null;
		} else {
			return addEntry(getRootNode(), newEntry);
		}
	}

	private T addEntry(IBinaryNode<T> rootNode, T newEntry) {
		T result = null;
		if (newEntry.compareTo(rootNode.getData()) == 0) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		} else if (newEntry.compareTo(rootNode.getData()) < 0) {
			if (rootNode.getLeftChild() != null) {
				result = addEntry(rootNode.getLeftChild(), newEntry);
			} else {
				rootNode.setLeftChild(new BinaryNode<T>(newEntry));
			}
		} else {
			if (rootNode.getRightChild() != null) {
				result = addEntry(rootNode.getRightChild(), newEntry);
			} else {
				rootNode.setRightChild(new BinaryNode<T>(newEntry));
			}
		}
		return result;
	}

	private class ReturnObject {
		private T data;

		public ReturnObject() {
			super();
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public ReturnObject(T data) {
			super();
			this.data = data;
		}
	}

	@Override
	public T remove(T anEntry) {
		ReturnObject oldEntry = new ReturnObject();
		IBinaryNode<T> newRoot = removeEntry(getRootNode(), anEntry, oldEntry);
		setRootNode(newRoot);
		return oldEntry.getData();
	}

	/**
	 * 从以指定节点为根的树中删除一个元素 ，并构建一棵“新的树”
	 * 
	 * @param rootNode
	 *            树的根节点的引用
	 * @param entry
	 *            待删除的树的对象
	 * @param oldEntry
	 *            数据域为null的对象
	 * @return 得到的树的节点 若entry与树中元素匹配，oldEntry的数据域就是从树中删除的该元素； 否则返回null。
	 */
	private IBinaryNode<T> removeEntry(IBinaryNode<T> rootNode, T entry,
			ReturnObject oldEntry) {
		if (rootNode != null) {
			T rootData = rootNode.getData();
			if (entry.compareTo(rootData) == 0) {
				oldEntry.setData(rootData);
				rootNode = removeFromRoot(rootNode);
			} else if (entry.compareTo(rootData) < 0) {
				IBinaryNode<T> leftChild = rootNode.getLeftChild();
				rootNode.setLeftChild(removeEntry(leftChild, entry, oldEntry));
			} else {
				IBinaryNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
			}
		}
		return rootNode;
	}

	/**
	 * 删除指定子树的根节点中的元素
	 * 
	 * @param rootNode
	 *            子树的根节点
	 * @return 修改后的子树的根节点
	 */
	private IBinaryNode<T> removeFromRoot(IBinaryNode<T> rootNode) {
		// 有两个子节点
		if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			IBinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			IBinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
			rootNode.setData(largestNode.getData());
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		} else if (rootNode.hasLeftChild()) {// 左节点
			rootNode = rootNode.getLeftChild();
		} else {// 右节点
			// 没有节点的情况在上一个函数返回null
			rootNode = rootNode.getRightChild();
		}
		return rootNode;
	}

	/**
	 * 在指定的树中删除最大元素的节点
	 * 
	 * @param rootNode
	 *            树的根节点
	 * @return 修改后的树节点
	 */
	private IBinaryNode<T> removeLargest(IBinaryNode<T> rootNode) {
		if (rootNode.hasRightChild()) {
			IBinaryNode<T> rightChild = rootNode.getRightChild();
			IBinaryNode<T> root = removeLargest(rightChild);
			rootNode.setRightChild(root);
		} else {
			rootNode = rootNode.getLeftChild();// 如果左节点有的情况，则返回；否则返回空
		}
		return rootNode;
	}

	/**
	 * 在指定的树中找寻最大元素的节点
	 * 
	 * @param rootNode
	 *            树的根节点
	 * @return 元素最大的节点
	 */
	private IBinaryNode<T> findLargest(IBinaryNode<T> rootNode) {
		if (rootNode.hasRightChild()) {
			rootNode = findLargest(rootNode.getRightChild());
		}
		// while (rootNode.hasRightChild()) {
		// rootNode = rootNode.getRightChild();
		// }
		return rootNode;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator<T>(getRootNode());
	}

}
