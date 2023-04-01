import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[301];
		int[] dp = new int[301];
		int total = 0;
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
			total += stairs[i];
		}
		if (N <= 2) {
			System.out.println(total);
			return;
		}
		dp[1] = stairs[1];
		dp[2] = stairs[2];
		dp[3] = stairs[3];
		for (int i = 4; i <= N-1; i++) {
			dp[i] = Math.min(dp[i-2], dp[i-3]) + stairs[i];
		}
		System.out.println(total-Math.min(dp[N-1], dp[N-2]));
	}
}