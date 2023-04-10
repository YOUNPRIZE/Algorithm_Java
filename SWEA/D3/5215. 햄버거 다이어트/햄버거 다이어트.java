import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[][] dp = new int[N][L];
			for (int i = 0; i < N; i++) {
				int Ti = sc.nextInt();
				int Ki = sc.nextInt();
				
				for (int j = 0; j < L; j++) {
					if (i == 0) {
						if (j >= Ki) {
							dp[i][j] = Ti;
						}
					} else {
						if (j >= Ki) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-Ki] + Ti);
						else dp[i][j] = dp[i-1][j];
					}
				}
			}
			sb.append(dp[N-1][L-1]).append("\n");
//			System.out.println(dp[N-1][L-1]);
		}
		System.out.println(sb.toString());
	}
}