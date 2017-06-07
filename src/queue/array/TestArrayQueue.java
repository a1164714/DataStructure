package queue.array;

public class TestArrayQueue {
	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println("getFront:"+queue.getFront());
		System.out.println("dequeue:"+queue.dequeue());
		System.out.println("clear");
		queue.clear();
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}
}
