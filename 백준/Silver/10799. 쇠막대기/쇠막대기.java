import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack;
        Scanner sc = new Scanner(System.in);
        stack = new Stack<>();
        // 총 개수
        int sum = 0;
        // 쇠막대기 개수
        int stick = 0;
        // 레이저 개수
        int laser = 0;

        String str = sc.next();
        // 문자열로 입력 받기
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' && str.charAt(i+1) == ')') {
                stack.push("()");
                i++;
            } else stack.push(String.valueOf(str.charAt(i)));
        }
        // 스택의 크기가 0이 아닐 때 계속 반복
        while (!stack.isEmpty()) {
            // 스택의 top이 ")" 일 때
            if (stack.peek().equals(")")) {
                stack.pop();
                sum++;
                stick++;
                // 스택의 top이 "()" 일 때
            } else if (stack.peek().equals("()")) {
                stack.pop();
                if(stick > 0) {
                    laser++;
                    sum += stick;
                }
                // 스택의 top이 "(" 일 때
            } else {
                stack.pop();
                stick--;
                if (stick == 0) {
                    laser = 0;
                }
            }
        }
//        System.out.printf("#%d %d\n", tc, sum);
        System.out.println(sum);
    }
}