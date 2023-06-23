import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
//        int[] number = new int[2000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
//            number[input[i]]++;
        }
        int x = Integer.parseInt(br.readLine());
        int ans = 0;
        Arrays.sort(input);
        for (int i = 0; i < N; i++) {
            if (input[i] != 0) {
                for (int j = i + 1; j < N; j++) {
                    if (input[i] + input[j] == x) {
                        ans++;
                        input[i] = 0;
                        input[j] = 0;
                        break;
                    }
                }
            }
        }


        

//        for (int i = 0; i < N; i++) {
//            if (number[x - input[i]] == 1) {
//                ans++;
//                number[input[i]] = 0;
//            }
//        }
        System.out.println(ans);
    }
}