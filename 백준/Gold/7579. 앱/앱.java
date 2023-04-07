import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] memory, cost;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		memory = new int[N];
		cost = new int[N];
		dp = new int[N][100001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		int ans = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= 10000; j++) {
					if (i == 0) {
						if (j >= cost[i]) dp[i][j] = memory[i];
					}
					else {
						if (j >= cost[i]) {
							dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+memory[i]);
						} else {
							dp[i][j] = dp[i-1][j];
						}
					}
					if (dp[i][j] >= M) ans = Math.min(ans, j);
			}
		} 
		
//		for (int i = 0; i <= N; i++) System.out.println(Arrays.toString(dp[i]));
		System.out.println(ans);
		
	}
}