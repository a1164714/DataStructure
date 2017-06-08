package queue.priorityqueue.linked;

import queue.priorityqueue.IPriorityQueue;

public class TestPriorityQueue {
	public static void main(String[] args) {
		IPriorityQueue<String> pQueue = new LinkedPriorityQueue<String>();
		pQueue.add("a");
		pQueue.add("c");
		pQueue.add("c");
		pQueue.add("b");
		pQueue.add("a");
		while (!pQueue.isEmpty()) {
			System.out.println(pQueue.remove());
		}
	}
}
