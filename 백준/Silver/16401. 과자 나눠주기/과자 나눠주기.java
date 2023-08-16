import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 조카의 수
        M = Integer.parseInt(st.nextToken());
        // 과자의 개수
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int start = 1;
        int end = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }
        // 1, 15
        // 1, 7
        //

        // 5, 7
        long length = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            length = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] / mid >= 1) length += arr[i] / mid;
            }
            if (length < M) end = mid - 1;
            else if (length >= M) start = mid + 1;
        }
        System.out.println(end);
    }
}