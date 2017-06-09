package tree.binarytree.binaryinterface;

public interface IBinaryNode<T> {
	T getData();

	void setData(T newEntry);

	IBinaryNode<T> getLeftChild();

	IBinaryNode<T> getRightChild();

	void setLeftChild(IBinaryNode<T> leftChild);

	void setRightChild(IBinaryNode<T> rightChild);

}
