import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String result = "ON";
			int N = sc.nextInt();
			int M = sc.nextInt();
			if (M == 0) {
				System.out.printf("#%d OFF\n", tc);
				continue;
			}
			for (int i = 0; i < N; i++) {
				if (M % 2 == 0) {
					result = "OFF";
					break;
				}
				M = M / 2;
			}
			System.out.printf("#%d %s\n", tc, result);
			
			
			
			
			
//			StringBuilder sb = new StringBuilder();
//			while(M != 1) {
//				if (M % 2 == 0) {
//					result = "OFF";
//					break;
//				}
//				sb.append(M % 2);
//				M = M / 2;
//			}
//			System.out.printf("#%d %s\n", tc, result);
//			sb.append(1);
//			String str = sb.toString();
//			if (str.length() < N) result = "OFF";
//			for (int i = 0; i < N; i++) {
//				if (str.charAt(i) == '0') {
//					result = "OFF";
//					break;
//				}
//			}
//			System.out.printf("#%d\ %s\n", tc, result);
		}
	}
}