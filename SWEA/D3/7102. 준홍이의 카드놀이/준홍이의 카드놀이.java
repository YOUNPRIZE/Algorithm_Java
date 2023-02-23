import java.util.Scanner;

public class Solution {
	static int N,M;
	static int[][] arr;
	static int[] cntArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N+1][M+1];
			cntArr = new int[N*M];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i][j] = i + j;
				}
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					cntArr[arr[i][j]] ++;
				}
			}
			int max = 0;
			for (int i = 0; i < cntArr.length; i++) {
				if (cntArr[i] > max) max = cntArr[i];
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < cntArr.length; i++) {
				if (max == cntArr[i]) System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
