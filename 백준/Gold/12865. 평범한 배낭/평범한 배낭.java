import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] dp;
	static int[] weight, value;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1];
		weight = new int[N+1];
		value = new int[N+1];
		dp[0][0] = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			weight[i] = W;
			value[i] = V;
		}
		
		// 물건의 개수
		for (int i = 1; i <= N; i++) {
			// 최대 무게의 범위
			for (int j = 1; j <= K; j++) {
				if (j >= weight[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
				} else dp[i][j] = dp[i-1][j];
			}
		}
//		for (int i = 1; i <= N; i++) System.out.println(Arrays.toString(dp[i]));
		System.out.println(dp[N][K]);
	}
}