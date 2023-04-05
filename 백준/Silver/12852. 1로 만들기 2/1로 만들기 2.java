import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		// 10^6 크기의 배열 생성
		int[] dp = new int[X+1];
		int[] visit = new int[X+1];
		// 초기값 설정 / 재귀에서 base case와 비슷한 맥락
		dp[1] = 0;
		// 1부터 위로 쌓아나가는 과정
		for (int i = 2; i <= X; i++) {
			dp[i] = dp[i-1] + 1;
			visit[i] = i - 1;
			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                visit[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                visit[i] = i / 2;
            }
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[X]);
//		System.out.print(X + " ");
//		int max = dp[X];
//		for (int i = X; i >= 1; i--) {
//			if (max > dp[i]) {
//				System.out.print(i + " ");
//				max = dp[i];
//			}
//		}
		String str = "";
		while (X > 0) {
			str += X + " ";
			X = visit[X];
		}
		
		System.out.println(str);
	}
	
	
}