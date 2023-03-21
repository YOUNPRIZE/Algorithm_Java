import java.util.Scanner;

// 2817. 부분 수열의 합
public class Solution {
	static int T,N,K,cnt,result;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			result = 0;
			recur(0);
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	public static void recur(int idx) {
		// base case
		if (idx == N) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				if (visit[i])
					cnt+=arr[i];
			}
			if (cnt == K) result++;
			return;
		}
		// recursive case
		visit[idx] = true;
		recur(idx + 1);
		visit[idx] = false;
		recur(idx + 1);
	}
}