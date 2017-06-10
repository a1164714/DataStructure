package tree.binarysearchtree;

import java.util.Iterator;

public class TestBinarySearchTree {
	public static void main(String[] args) {
		// Represent each leaf as a one-node tree
		IBinarySearchTree<String> aTree = new BinarySearchTree<String>();
		aTree.add("a");
		aTree.add("c");
		aTree.add("e");
		aTree.add("f");
		aTree.add("b");
		aTree.add("d");
		System.out.println("contain(a):"+aTree.contain("a"));
		System.out.println("getHeight():"+aTree.getHeight());
		System.out.println("numberOfNodes():"+aTree.getNumberOfNodes());
		System.out.println("remove(c):"+aTree.remove("c"));
		Iterator<String> iterator = aTree.getInorderIterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}
	}
}
