package tree.heap.priorityqueue;

import queue.priorityqueue.IPriorityQueue;

public class TestPriorityQueue {
	public static void main(String[] args) {
		IPriorityQueue<String> pQueue = new HeapPriorityQueue<String>();
		pQueue.add("a");
		pQueue.add("b");
		pQueue.add("c");
		pQueue.add("b");
		pQueue.add("b");
		System.out.println("size:"+pQueue.getSize());
		while (!pQueue.isEmpty()) {
			System.out.println(pQueue.remove());
		}
	}
}
