import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N,T, min, max, total, cheese, num;
	static int[][] graph;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			graph = new int[N][N];
//			min = Integer.MAX_VALUE;
//			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = sc.nextInt();
//					min = Math.min(min, graph[i][j]);
//					max = Math.max(max, graph[i][j]);
				}
			}
//			System.out.println(min);
//			System.out.println(max);
			total = 0;
			for (num = 0; num <= 100; num++) {
//				System.out.println(num);
				cheese = 0;
				visit = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (graph[i][j] > num && !visit[i][j]) {
							bfs(i, j);
						}
					}
				}
				total = Math.max(total, cheese);
			}
//			System.out.println(total);
			sb.append(total).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs(int x, int y) {
		q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] ele = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = ele[0] + dx[i];
				int ny = ele[1] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(visit[nx][ny]) continue;
				if(graph[nx][ny] <= num) continue;
				visit[nx][ny] = true;
				q.add(new int[] {nx, ny});
 			}
		}
		cheese++;
	}
}