package tree.binarytree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import queue.queue.IQueue;
import queue.queue.linked.LinkedQueue;
import stack.IStack;
import stack.linkedstack.LinkedStack;
import tree.binarytree.binaryinterface.IBinaryNode;
import tree.binarytree.binaryinterface.IBinaryTree;
import tree.binarytree.exception.EmptyTreeException;
import tree.binarytree.iterator.InOrderIterator;
import tree.binarytree.iterator.LevelOrderIterator;
import tree.binarytree.iterator.PostOrderIterator;
import tree.binarytree.iterator.PreOrderIterator;

public class BinaryTree<T> implements IBinaryTree<T> {
	private BinaryNode<T> root;

	// start protected ?
	protected void setRootData(T rootData) {
		root.setData(rootData);
	}

	protected void setRootNode(IBinaryNode<T> rootNode) {
		root = (BinaryNode<T>) rootNode;
	}

	protected IBinaryNode<T> getRootNode() {
		return root;
	}

	// end protected ?

	@Override
	public T getRootData() throws EmptyTreeException {
		if (isEmpty())
			throw new EmptyTreeException();
		else
			return root.getData();
	}

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public Iterator<T> getPreOrderIterator() {
		return new PreOrderIterator<T>(root);
	}

	@Override
	public Iterator<T> getPostOrderIterator() {
		return new PostOrderIterator<T>(root);
	}

	@Override
	public Iterator<T> getInOrderIterator() {
		return new InOrderIterator<T>(root);
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		return new LevelOrderIterator<T>(root);
	}

	@Override
	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}

	@Override
	public void setTree(T rootData, IBinaryTree<T> leftTree,
			IBinaryTree<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>) leftTree,
				(BinaryTree<T>) rightTree);
	}

	/**
	 * @Title: privateSetTree
	 * @Description: 复制树的花销太大，下面为改进方案
	 * @param rootData
	 * @param leftTree
	 * @param rightTree
	 * @return：void
	 * @Date:2017年6月9日 上午9:20:32
	 * @Author:LinZF
	 */
	// private void privateSetTree(T rootData, BinaryTree<T> leftTree,
	// BinaryTree<T> rightTree) {
	// root = new BinaryNode<T>(rootData);
	// if (leftTree != null && !leftTree.isEmpty()) {
	// root.setLeftChild(leftTree.root.copy());
	// }
	// if (rightTree != null && !rightTree.isEmpty()) {
	// root.setRightChild(rightTree.root.copy());
	// }
	// }

	private void privateSetTree(T rootData, BinaryTree<T> leftTree,
			BinaryTree<T> rightTree) {
		root = new BinaryNode<>(rootData);
		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);
		if ((rightTree != null) && !rightTree.isEmpty()) {
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		}
		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();
		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	}

	public BinaryNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}

	public void levelOrderTraverse() {
		if (root == null)
			return;
		IQueue<IBinaryNode<T>> q = new LinkedQueue<IBinaryNode<T>>();
		q.enqueue(root);
		while (!q.isEmpty()) {
			IBinaryNode<T> temp = q.dequeue();
			System.out.println(temp.getData());
			if (temp.getLeftChild() != null)
				q.enqueue(temp.getLeftChild());
			if (temp.getRightChild() != null)
				q.enqueue(temp.getRightChild());
		}
	}

	public void preOrderTraverse() {
		IStack<IBinaryNode<T>> nodeStack = new LinkedStack<IBinaryNode<T>>();
		IBinaryNode<T> currentNode = root;
		IBinaryNode<T> rightNode = null;
		while (currentNode != null || !nodeStack.isEmpty()) {
			if (currentNode != null) {
				nodeStack.push(currentNode);
				rightNode = currentNode.getRightChild();
				currentNode = currentNode.getLeftChild();
			}
			System.out.println(nodeStack.pop().getData());
			if (rightNode != null) {
				nodeStack.push(rightNode);
			}
		}
	}

	/** 栈实现 **/
	public void postOrderTraverse() {
		IStack<IBinaryNode<T>> nodeStack = new LinkedStack<IBinaryNode<T>>();
		Set<IBinaryNode<T>> set = new HashSet<IBinaryNode<T>>();
		nodeStack.push(root);
		while (!nodeStack.isEmpty()) {
			IBinaryNode<T> tmp = nodeStack.peek();
			if (tmp.getLeftChild() != null && !set.contains(tmp.getLeftChild())) {
				tmp = tmp.getLeftChild();
				nodeStack.push(tmp);
				continue;
			}
			if (tmp.getRightChild() != null
					&& !set.contains(tmp.getRightChild())) {
				nodeStack.push(tmp.getRightChild());
				continue;
			}
			set.add(nodeStack.peek());
			System.out.println(nodeStack.pop().getData());
		}
	}

	/** 栈实现 **/
	public void inOrderTraverseStack() {
		IStack<IBinaryNode<T>> nodeStack = new LinkedStack<IBinaryNode<T>>();
		IBinaryNode<T> currentNode = root;
		while (!nodeStack.isEmpty() || currentNode != null) {
			// 查询没有左孩子的最左结点
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			// 访问最左结点，然后遍历它的右子树
			if (!nodeStack.isEmpty()) {
				IBinaryNode<T> nextNode = nodeStack.pop();
//				System.out.println(nextNode.getData());
				currentNode = nextNode.getRightChild();
			}
		}
	}

	/** 递归实现 **/
	public void inOrderTraverse() {
		inOrderTraverse(root);
	}

	private void inOrderTraverse(BinaryNode<T> node) {
		if (node != null) {
			inOrderTraverse((BinaryNode<T>) node.getLeftChild());
//			System.out.println(node.getData());
			inOrderTraverse((BinaryNode<T>) node.getRightChild());
		}
	}

}
