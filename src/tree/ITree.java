package tree;

import tree.binarytree.exception.EmptyTreeException;

public interface ITree<T> {
	T getRootData() throws EmptyTreeException;

	int getHeight();

	int getNumberOfNodes();

	boolean isEmpty();

	void clear();
}
