import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] coins;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			coins = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				
				coins[i] = Integer.parseInt(st.nextToken()); 
			}
			int M = Integer.parseInt(br.readLine());
			dp = new int[M+1];
			
			// 동전의 개수
			for (int i = 1; i <= N; i++) {
				// 동전으로 만들어야 할 금액
				for (int j = 1; j <= M; j++) {
					if (j > coins[i]) {
						dp[j] = dp[j] + dp[j-coins[i]];
					} else if (j == coins[i]) dp[j]++;
				}
			}
			System.out.println(dp[M]);
		}
	}
}