import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Character> stack, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        stack = new Stack<>();
        temp = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.add(str.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                // 왼쪽 키보드를 눌렀을 때, stack에서 temp로 한 개 옮긴다.
                case "L":
                    if (!stack.isEmpty()) {
                        temp.add(stack.pop());
                    }
                    break;
                // 오른쪽 키보드를 눌렀을 때, temp에서 stack으로 한 개 옮긴다.
                case "D":
                    if (!temp.isEmpty()) {
                        stack.add(temp.pop());
                    }
                    break;
                // 백스페이스를 눌렀을 때, stack에서 한 개 제거한다.
                case "B":
                    if (!stack.isEmpty()) stack.pop();
                    break;
                // 문자, 숫자를 눌렀을 때, stack에 삽입한다.
                default:
                    String s = st.nextToken();
                    stack.add(s.charAt(0));
                    break;
            }
        }
        // temp로 옮긴 것들을 다 stack으로 옮겨준다.
        while(!temp.isEmpty()) {
            stack.add(temp.pop());
        }
        // 비밀번호만 담긴 stack에서 StringBuilder에 넣어준다.
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // 현재는 비밀번호가 거꾸로 뒤집어져 있으므로 반대로 뒤집어준다.
        sb.reverse();
        // 출력한 후에, sb를 초기화 시킨다.
        System.out.println(sb.toString());
    }
}