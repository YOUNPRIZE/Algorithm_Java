import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N,M, max;
	static int[][] graph;
	static boolean[][] visit;
	static Queue<int[]> q, q2;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		q = new LinkedList<>();
		
		graph = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				// 바다는 -1로
				if (str.charAt(j) == 'W') graph[i][j] = -1;
				// 육지는 0으로 초기화
				else graph[i][j] = 0;
			}
		}
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					visit = new boolean[N][M];
					bfs(i, j);
				}
			}
		}
		System.out.println(max);
	}
	
	public static void bfs(int x, int y) {
		q.add(new int[] {x, y, 0});
		visit[x][y] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
				if (graph[nx][ny] == 0 && !visit[nx][ny]) {
					visit[nx][ny] = true;
//					graph[nx][ny] = graph[cx][cy] + 1;
					if (max < curr[2]+1) max = curr[2]+1;
					q.add(new int[] {nx, ny, curr[2]+1});
				}
			}
		}
	}
}