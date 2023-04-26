import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R, X;
	static int result = 0;
	static int[] diff;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 문제의 개수
		N = Integer.parseInt(st.nextToken());
		diff = new int[N];
		visit = new boolean[N];
		// 문제의 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다.
		// L <= 난이도의 합 <= R
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		// 가장 어려운 문제의 난이도 - 가장 쉬운 문제의 난이도 >= X
		X= Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			diff[i] = Integer.parseInt(st.nextToken());
		}
		
		powerset(0);
		System.out.println(result);
	}
	
	public static void powerset(int idx) {
		// base case
		if (idx == N) {
			int cnt = 0;
			int sum = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
//					System.out.print(diff[i] + " ");
					cnt++;
					sum += diff[i];
					min = Math.min(min, diff[i]);
					max = Math.max(max, diff[i]);
				}
			}
//			System.out.println();
			if (cnt < 2) return;
			if (sum <= R && sum >= L && max - min >= X) result++;
			return;
		}
		// recur case
		visit[idx] = true;
		powerset(idx + 1);
		
		visit[idx] = false;
		powerset(idx + 1);
	}
}