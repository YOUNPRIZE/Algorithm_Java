import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N+1];
		int[] dp = new int[K+1];
		for (int i = 1; i <= N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			// 동전으로 만들어야 할 금액
			for (int j = 1; j <= K; j++) {
				if (j > coins[i]) {
					dp[j] = dp[j] + dp[j-coins[i]];
				} else if (j == coins[i]) dp[j]++;
			}
		}
		System.out.println(dp[K]);
	}
}