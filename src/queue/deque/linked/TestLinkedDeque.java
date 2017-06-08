package queue.deque.linked;

import queue.deque.IDeque;

public class TestLinkedDeque {
	public static void main(String[] args) {
		IDeque<Integer> deque = new LinkedDeque<Integer>();
		deque.addToFront(1);
		deque.addToBack(2);
		System.out.println(deque.getFront());
		System.out.println(deque.getBack());
		System.out.println(deque.removeFront());
		System.out.println(deque.removeBack());
		deque.clear();
		System.out.println(deque.getFront());
		System.out.println(deque.getBack());
	}
}
