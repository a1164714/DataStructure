package stack.arraystack;

public class TestArrayStack {
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		stack.push(2);
		stack.push(1);
		System.out.println("peek:"+stack.peek());
		while (!stack.isEmpty()) {
			System.out.println("pop:"+stack.pop());
		}
	}
}
