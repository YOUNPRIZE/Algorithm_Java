import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution {
	static Stack<Character> stack1;
	static Stack<Character> stack2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d ", tc);
			stack1 = new Stack<>();
			stack2 = new Stack<>();
			int L = sc.nextInt();
			
			String str = sc.next();
			
			boolean check = true;
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '<') {
					stack1.push(str.charAt(i));
				} else {
					if (str.charAt(i) == ')') {
						while (!stack1.isEmpty() && stack1.peek() != '(') {
							stack2.push(stack1.pop());
						}
						// 없을 때
						if (stack1.isEmpty()) {
							check = false;
							break;
						} else {
							stack1.pop();
							while(!stack2.isEmpty()) {
								stack1.push(stack2.pop());
							}
						}
					} else if (str.charAt(i) == ']') {
						while (!stack1.isEmpty() && stack1.peek() != '[') {
							stack2.push(stack1.pop());
						}
						// 없을 때
						if (stack1.isEmpty()) {
							check = false;
							break;
						} else {
							stack1.pop();
							while(!stack2.isEmpty()) {
								stack1.push(stack2.pop());
							}
						}
					} else if (str.charAt(i) == '}') {
						while (!stack1.isEmpty() && stack1.peek() != '{') {
							stack2.push(stack1.pop());
						}
						// 없을 때
						if (stack1.isEmpty()) {
							check = false;
							break;
						} else {
							stack1.pop();
							while(!stack2.isEmpty()) {
								stack1.push(stack2.pop());
							}
						}
					} else {
						while (!stack1.isEmpty() && stack1.peek() != '<') {
							stack2.push(stack1.pop());
						}
						// 없을 때
						if (stack1.isEmpty()) {
							check = false;
							break;
						} else {
							stack1.pop();
							while(!stack2.isEmpty()) {
								stack1.push(stack2.pop());
							}
						}
					}
				}
			}
			if (check) System.out.println(1);
			else System.out.println(0);
		}
	}
}