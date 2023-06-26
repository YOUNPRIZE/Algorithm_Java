import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (stack.isEmpty()) stack.add(str.charAt(j));
                else {
                    if (stack.peek() == str.charAt(j)) {
                        stack.pop();
                    } else stack.add(str.charAt(j));
                }
            }
            if (stack.isEmpty()) ans++;
        }
        System.out.println(ans);
    }
}