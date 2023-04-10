import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] graph, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0) {
					if (j == 0) dp[i][j] = graph[i][j];
					else dp[i][j] = graph[i][j] + dp[i][j-1];
				} else if (j == 0) {
					dp[i][j] = dp[i-1][j] + graph[i][j];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i > 0 && j >0) {
					dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + graph[i][j];
				}
			}
		}
//		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(dp[i]));
		System.out.println(dp[N-1][M-1]);
	}
}