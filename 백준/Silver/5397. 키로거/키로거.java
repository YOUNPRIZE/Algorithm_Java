import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            stack = new Stack<>();
            temp = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                char pw = str.charAt(j);
                switch (pw) {
                    case '<':
                        if (!stack.isEmpty()) {
                            temp.add(stack.pop());
                        }
                        break;
                    case '>':
                        if (!temp.isEmpty()) {
                            stack.add(temp.pop());
                        }
                        break;
                    case '-':
                        if (!stack.isEmpty()) stack.pop();
                        break;
                    default:
                        stack.add(pw);
                        break;
                }
            }
            while(!temp.isEmpty()) {
                stack.add(temp.pop());
            }
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();
            System.out.println(sb.toString());
            sb.setLength(0);
//            sb.append("\n");
        }
//        System.out.println(sb.toString());
    }
}