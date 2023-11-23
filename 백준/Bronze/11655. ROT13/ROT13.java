import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int idx = ch - '0';
            // 대문자 일 때
            if (idx >= 17 && idx <= 42) {
                idx = idx + 13;
                if (idx > 42) {
                    int temp = idx - 42;
                    idx = 16 + temp;
                }
                sb.append((char) (idx + '0'));
            } else if (idx >= 49 && idx <= 74) {
                idx = idx + 13;
                if (idx > 74) {
                    int temp = idx - 74;
                    idx = 48 + temp;
                }
                sb.append((char) (idx + '0'));
//                System.out.println(idx);
            } else sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}


// 49 74 17 42 a z A z