import java.util.Scanner;

public class Solution {
	// y좌표 일치?
	static boolean[] visitY = new boolean[40];
	// 오른쪽 위로 가는 방향의 대각
	static boolean[] visitRightUp = new boolean[40];
	// 오른쪽 아래로 가는 방향의 대각
	static boolean[] visitRightDown = new boolean[40];
	static int cnt, N, T = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cnt = 0;
			backtracking(0);
			System.out.printf("#%d ", tc);
			System.out.println(cnt);
		}
	}
	public static void backtracking(int num) {
		// base case
		if (num == N) {
			cnt++;
			return;
		}
		// recursive case
		for (int i = 0; i < N; i++) {
			if (visitY[i] || visitRightUp[i+num] || visitRightDown[num-i+N-1]) continue;
			visitY[i] = true;
			visitRightUp[i + num] = true;
			visitRightDown[num-i+N-1] = true;
			backtracking(num+1);
			visitY[i] = false;
			visitRightUp[i + num] = false;
			visitRightDown[num-i+N-1] = false;
		}
	}
}