
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] charArr = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = charArr[j] - '0';
				}
			}
			// 색칠? 해야될 칸에 대한 변수 크기 설정
			int blue = N / 2;
			
			// 총합 변수 선언 및 초기화
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 행기준 중앙에 위치해있을 때
//					if (i == N / 2) {
						if (j >= blue && j < N - blue) {
							sum += arr[i][j];
						}
//					}
//					// 행 기준
//					else if (i >= N - N / 2) {
//						if (j >= blue && j < N - blue) {
//							sum += arr[i][j];
//						}
//					// 행기준 중앙보다 낮을 때
//					} else {
//						if (j >= blue && j < N - blue) {
//							sum += arr[i][j];
//						}
//					}
				}
				if (i >= N / 2) blue++;
				else blue--;
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
