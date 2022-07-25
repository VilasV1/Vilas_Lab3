package com.greatlearning.balancingbrackets.main;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
	public static void main(String[] args) {
		String expression;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression to be checked");
		expression = sc.next();

		if (isBalanced(expression))
			System.out.println("The String has Balanced expression");
		else
			System.out.println("The String do not contain Balanced expression");
	}

	private static boolean isBalanced(String expression) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{') {

				stack.push(ch);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}
			char check;
			switch (ch) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[') {
					return false;
				}
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[') {
					return false;
				}
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{') {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();

	}

}
