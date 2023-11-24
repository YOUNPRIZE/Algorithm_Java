import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N명의 학생
        int L = Integer.parseInt(st.nextToken()); // 원치 않는 라벨 숫자 L
        String dont = String.valueOf(L);
        int cnt = N;
        int start = 1;
        while (cnt > 0) {
            String str = String.valueOf(start);
            if (str.contains(dont)) {
                start++;
                continue;
            }
            else cnt--;
            if (cnt == 0) {
                System.out.println(start);
                break;
            }
            start++;
        }
    }
}