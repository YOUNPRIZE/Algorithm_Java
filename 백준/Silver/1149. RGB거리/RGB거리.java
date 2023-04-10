import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			int[] RGB = new int[3];
			for (int j = 0; j < 3; j++) {
				RGB[j] = sc.nextInt();
				if (i == 0) {
					dp[i][0] = RGB[0];
					dp[i][1] = RGB[1];
					dp[i][2] = RGB[2];
				} else {
					dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[0];
					dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[1];
					dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + RGB[2];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dp[N-1][i]);
		}
		System.out.println(min);
	}
}