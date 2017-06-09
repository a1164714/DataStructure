package tree.binarytree;

import java.util.Iterator;

import tree.binarytree.binaryinterface.IBinaryTree;
import tree.binarytree.exception.EmptyTreeException;

public class TestBinaryTree {
	public static void main(String[] args) {
		// abcdefgh
		// Represent each leaf as a one-node tree
		IBinaryTree<String> cTree = new BinaryTree<>();
		cTree.setTree("3");
		IBinaryTree<String> dTree = new BinaryTree<>();
		dTree.setTree("4");
		IBinaryTree<String> fTree = new BinaryTree<>();
		fTree.setTree("5");
		// Form larger subtrees
		IBinaryTree<String> bTree = new BinaryTree<>();
		bTree.setTree("2", dTree, fTree);
		IBinaryTree<String> aTree = new BinaryTree<String>();
		aTree.setTree("1", bTree, cTree);
		System.out.println("--->前序序列");
		Iterator<String> iterator2 = aTree.getPreOrderIterator();
		while (iterator2.hasNext()) {
			String next = iterator2.next();
			System.out.println(next);
		}
		System.out.println("--->中序序列");
		Iterator<String> iterator1 = aTree.getInOrderIterator();
		while (iterator1.hasNext()) {
			String next = iterator1.next();
			System.out.println(next);
		}
		System.out.println("--->后序序列");
		Iterator<String> iterator3 = aTree.getPostOrderIterator();
		while (iterator3.hasNext()) {
			String next = iterator3.next();
			System.out.println(next);
		}
		System.out.println("--->层级序列");
		Iterator<String> iterator4 = aTree.getLevelOrderIterator();
		while (iterator4.hasNext()) {
			String next = iterator4.next();
			System.out.println(next);
		}
		long start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			((BinaryTree<String>) aTree).inOrderTraverseStack();
		}
		long end = System.nanoTime();
		System.out.println("inOrderTraverseStack:" + (end - start));
		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			((BinaryTree<String>) aTree).inOrderTraverse();
		}
		end = System.nanoTime();
		System.out.println("inOrderTraverse:" + (end - start));
	}
}
