import java.util.Scanner;

public class Solution {
	static int T,N,L,max;
	static boolean[] use;
	static int[] grade, cal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			grade = new int[N];
			cal = new int[N];
			use = new boolean[N];
			L = sc.nextInt();
			for (int i = 0 ; i < N; i++) {
				grade[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			max = Integer.MIN_VALUE;
			recur(0);
			System.out.printf("#%d %d\n", tc, max);
		}
	}
	public static void recur(int idx) {
		// base case
		if (idx == N) {
			int cntCal = 0;
			int cntGrade = 0;
			for (int i = 0; i < N; i++) {
				// 사용했다면
				if(use[i]) {
					cntCal += cal[i];
					cntGrade += grade[i];
				}
			}
			if (cntCal <= L) max = Math.max(max, cntGrade);
			return;
		}
		// recur case
		use[idx] = true;
		recur(idx + 1);
		use[idx] = false;
		recur(idx + 1);
	}
}