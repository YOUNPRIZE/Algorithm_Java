import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int N, M;
	static String[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new String[N+1];
			
			for (int i = 1; i <= N; i++) {
				arr[i] = sc.next();
			}
			
			// 첫 번째 줄 하얀색은 고정
			// sum += arr[1].length() - arr[1].replace("W", "").length();
			// 마지막줄 빨간색은 고정
			// sum += arr[N].length() - arr[N].replace("R", "").length();
			
			int change = Integer.MAX_VALUE;
			int sumW = 0;
			int sumB = 0;
			int sumR = 0;
			
			for (int i = 1; i <= N-2; i++) {
				sumW += arr[i].replace("W", "").length();
				for (int j = i + 1; j <= N-1; j++) {
					sumB += arr[j].replace("B", "").length();
					for (int k = j + 1; k <= N; k++) {
						sumR += arr[k].replace("R", "").length();
					}
					if (change > (sumW + sumB + sumR)) {
						change = sumW + sumB + sumR;
					}
					sumR = 0;
				}
				sumB = 0;
			}
			System.out.printf("#%d %d\n", tc, change);
		}
	}
}