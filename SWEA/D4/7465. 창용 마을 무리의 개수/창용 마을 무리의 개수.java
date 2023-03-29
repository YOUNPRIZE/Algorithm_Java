import java.util.Scanner;

public class Solution {
	static int N, M, cnt;
	static int[][] graph;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();
			M = sc.nextInt();
			graph = new int[N+1][N+1];
			visit = new boolean[N+1];
			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				graph[A][B] = 1;
				graph[B][A] = 1;
			}
			cnt = 0;
			for (int i = 1; i <= N; i++) {
				boolean flag = false;
				for (int j = 1; j <= N; j++) {
					if (graph[i][j] == 1) flag = true;
					if(!visit[j] && graph[i][j] == 1) {
						dfs(j);
						cnt++;
					}
				}
				if (!flag&&!visit[i]) cnt++;
			}
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int row) {
		visit[row] = true;
		for (int i = 1; i <= N; i++) {
			if (graph[row][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
}