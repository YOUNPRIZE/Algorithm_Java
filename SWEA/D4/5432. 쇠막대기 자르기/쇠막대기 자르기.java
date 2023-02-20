import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Stack<String> stack;
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			stack = new Stack<>();
			// 총 개수
			int sum = 0;
			// 쇠막대기 개수
			int stick = 0;
			// 레이저 개수
			int laser = 0;
			
			String str = sc.next();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' && str.charAt(i+1) == ')') {
					stack.push("()");
					i++;
				} else stack.push(String.valueOf(str.charAt(i)));
			}
			while (!stack.isEmpty()) {
				if (stack.peek().equals(")")) {
					stack.pop();
					sum++;
					stick++;
				} else if (stack.peek().equals("()")) {
					stack.pop();
					if(stick > 0) {
						laser++;
						sum += stick;
					}
				} else {
					stack.pop();
					stick--;
					if (stick == 0) {
						laser = 0;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}