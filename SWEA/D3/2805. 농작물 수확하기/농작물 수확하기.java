
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
			int blue = N / 2;
			
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == N / 2) {
						if (j >= blue && j < N - blue) {
							sum += arr[i][j];
							//System.out.println(arr[i][j]);
						}
					}
					else if (i >= N - N / 2) {
						if (j >= blue && j < N - blue) {
							sum += arr[i][j];
							//System.out.println(arr[i][j]);
						}
					} else {
						if (j >= blue && j < N - blue) {
							sum += arr[i][j];
							//System.out.println(arr[i][j]);
						}
					}
				}
				if (i >= N / 2) blue++;
				else blue--;
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
