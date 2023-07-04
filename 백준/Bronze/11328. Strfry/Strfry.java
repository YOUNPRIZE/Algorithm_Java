import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] arr = new int[75];
            st = new StringTokenizer(br.readLine());
            String strA = st.nextToken();
            String strB = st.nextToken();

//            System.out.println('a' - '0'); // 49

//            System.out.println('z' - '0'); // 74

            for (int j = 0; j < strB.length(); j++) {
                arr[strB.charAt(j) - '0']++;
            }

            for (int j = 0; j < strA.length(); j++) {
                arr[strA.charAt(j) - '0']--;
            }

            boolean check = true;

            for (int j = 0; j <= 74; j++) {
                if (arr[j] != 0) {
                    check = false;
                    break;
                }
            }

            if (check) sb.append("Possible").append("\n");
            else sb.append("Impossible").append("\n");
        }
        System.out.println(sb.toString());
    }
}