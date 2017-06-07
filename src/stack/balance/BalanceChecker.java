package stack.balance;

import stack.IStack;
import stack.linkedstack.LinkedStack;

public class BalanceChecker {
	public static boolean checkBalance(String expression) {
		IStack<Character> openDelimiterStack = new LinkedStack<Character>();
		int length = expression.length();
		Character nextChar = ' ';
		int index = 0;
		boolean isBalanced = true;
		while (isBalanced && index < length) {
			nextChar = expression.charAt(index);
			switch (nextChar) {
			case '(':
			case '[':
			case '{':
				openDelimiterStack.push(nextChar);
				break;
			case ')':
			case ']':
			case '}':
				if (openDelimiterStack.isEmpty()) {
					isBalanced = false;
				}
				Character openDelimiter = openDelimiterStack.pop();
				isBalanced = checkPair(openDelimiter, nextChar);
				break;
			default:
				break;
			}
			index++;
		}
		if (!openDelimiterStack.isEmpty()) {
			isBalanced = false;
		}
		return isBalanced;
	}

	private static boolean checkPair(Character open, Character close) {
		return (open == '[' && close == ']') 
				|| (open == '(' && close == ')')
				|| (open == '{' && close == '}');
	}
}
