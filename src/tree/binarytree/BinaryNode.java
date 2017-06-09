package tree.binarytree;

import tree.binarytree.binaryinterface.IBinaryNode;

public class BinaryNode<T> implements IBinaryNode<T> {
	private T data;
	private BinaryNode<T> leftChild;
	@Override
	public String toString() {
		return "BinaryNode [data=" + data + "]";
	}

	private BinaryNode<T> rightChild;

	public BinaryNode() {
		this(null);
	}

	public BinaryNode(T dataPortion) {
		this(dataPortion, null, null);
	}

	public BinaryNode(T dataPortion, BinaryNode<T> leftChild,
			BinaryNode<T> rightChild) {
		this.data = dataPortion;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(T newEntry) {
		data = newEntry;
	}

	@Override
	public IBinaryNode<T> getLeftChild() {
		return leftChild;
	}

	@Override
	public IBinaryNode<T> getRightChild() {
		return rightChild;
	}

	@Override
	public void setLeftChild(IBinaryNode<T> newleftChild) {
		this.leftChild = (BinaryNode<T>) newleftChild;
	}

	@Override
	public void setRightChild(IBinaryNode<T> newRightChild) {
		this.rightChild = (BinaryNode<T>) newRightChild;
	}

	public boolean hasLeftChild() {
		return leftChild != null;
	}

	public boolean hasRightChild() {
		return rightChild != null;
	}

	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}

	public int getNumberOfNodes() {
		int leftNumber = 0;
		int rightNumber = 0;
		if (leftChild != null) {
			leftNumber = leftChild.getNumberOfNodes();
		}
		if (rightChild != null) {
			rightNumber = rightChild.getNumberOfNodes();
		}
		return 1 + leftNumber + rightNumber;
	}

	public int getHeight() {
		return getHeight(this);
	}

	private int getHeight(BinaryNode<T> binaryNode) {
		int height = 0;
		if (binaryNode != null) {
			height = 1 + Math.max(getHeight(binaryNode.leftChild),
					getHeight(binaryNode.rightChild));
		}
		return height;
	}

	public BinaryNode<T> copy() {
		// 不复制结点中的数据
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		if (leftChild != null) {
			newRoot.setLeftChild(leftChild.copy());
		}
		if (rightChild != null) {
			newRoot.setRightChild(rightChild.copy());
		}
		return newRoot;
	}

}
