import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int[] cost = new int[4];
			int[] dp = new int[13];
//			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
//				cost[i] = Integer.parseInt(st.nextToken());
			}
//			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				int days = sc.nextInt();
//				int days = Integer.parseInt(st.nextToken());
				
				dp[i] = Math.min(dp[i-1] + days * cost[0], dp[i-1] + cost[1]);
				
				if (i >= 3) dp[i] = Math.min(dp[i], dp[i-3] + cost[2]);
			}
			sb.append(Math.min(dp[12], cost[3])).append("\n");
		}
		System.out.println(sb.toString());
	}
}