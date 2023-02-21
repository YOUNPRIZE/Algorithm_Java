import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			
			String str = sc.next();
			
			String post = "";
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '+' || str.charAt(i) == '*') {
					if (str.charAt(i) == '+') {
						while (!stack.isEmpty() && stack.peek() != '(') {
							post = post + stack.pop();
						}
						stack.push('+');
					} else {
						while (!stack.isEmpty() && stack.peek() == '*') {
							post = post + stack.pop();
						}
						stack.push('*');
					}
				} else post = post + str.charAt(i);
			}
			while (!stack.isEmpty()) {
				post = post + stack.pop();
			}
			
			Stack<Integer> stack2 = new Stack<>();
			
			for (int i = 0; i < post.length(); i++) {
				if (post.charAt(i) == '+') {
					stack2.push(stack2.pop() + stack2.pop());
				} else if (post.charAt(i) == '*') {
					stack2.push(stack2.pop() * stack2.pop());
				} else {
					stack2.push(post.charAt(i) - '0');
				}
			}
			System.out.printf("#%d %d\n", tc, stack2.pop());
		}
	}
}