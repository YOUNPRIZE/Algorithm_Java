import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String order = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String array = br.readLine().replace("[", "").replace("]", ""); // 대괄호 제거
            if (array.length() == 0 && order.contains("D")) { // 빈 배열 처리
                sb.append("error").append("\n");
                continue;
            }
            String[] str = array.split(",");
            Deque<String> dq = new ArrayDeque<>();
            for (int j = 0; j < str.length; j++) {
                dq.offerLast(str[j]);
            }
            boolean direction = true;
            boolean error = false; // 에러 상태 체크 변수
            for (int k = 0; k < order.length(); k++) {
                if (order.charAt(k) == 'R') {
                    direction = !direction;
                } else if (order.charAt(k) == 'D') {
                    if (dq.size() == 0) {
                        error = true; // 에러 상태로 변경
                        break;
                    } else {
                        if (direction) dq.pollFirst();
                        else dq.pollLast();
                    }
                }
            }
            if (error) {
                sb.append("error").append("\n");
                continue;
            }
            int size = dq.size();
            sb.append("[");
            if (direction) {
                for (int j = 0; j < size; j++) {
                    sb.append(dq.pollFirst()).append(",");
                }
            } else {
                for (int j = 0; j < size; j++) {
                    sb.append(dq.pollLast()).append(",");
                }
            }
            if (size > 0) {
                sb.deleteCharAt(sb.length() - 1); // 마지막 콤마 제거
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}