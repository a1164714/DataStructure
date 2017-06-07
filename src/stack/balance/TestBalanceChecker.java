package stack.balance;

public class TestBalanceChecker {
	public static void main(String[] args) {
		String expression = "a {b [c (d + e)/2 - f] + 1}";
		boolean isBalanced = BalanceChecker.checkBalance(expression);
		if (isBalanced)
			System.out.println(expression + " is balanced");
		else
			System.out.println(expression + " is not balanced");
	}
}
