import java.util.Scanner;

public class Solution {
	static int T,N,B,min;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			B = sc.nextInt();
			arr = new int[N];
			visit = new boolean[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			powerset(0);
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void powerset(int idx) {
		// base case
		if (idx == N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (visit[i]) cnt += arr[i];
			}
			if (cnt >= B) {
				min = Math.min(min, cnt - B);
			}
			return;
		}
		
		// recursive case
		visit[idx] = true;
		powerset(idx + 1);
		
		visit[idx] = false;
		powerset(idx + 1);
		
	}
}