import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Node {
		int x;
		int y;
		int cnt;
		int wall;
		public Node(int x, int y, int cnt, int wall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
		}
	}
	static int N,M,K, result;
	static int[][] graph;
	static boolean[][][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMK = br.readLine().split(" ");
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		K = Integer.parseInt(NMK[2]);
		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		result = -1;
		bfs();
		System.out.println(result);
	}
	
	public static void bfs() {
		q = new LinkedList<>();
		visit = new boolean[N][M][K+1];
		q.add(new Node(0, 0, 1, 0));
		visit[0][0][0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
//			int cCnt = cur.cnt;
//			if (cCnt >= result) break;
			if (cx == N - 1 && cy == M - 1) {
				result = cur.cnt;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				// 벽이 아닐 때
				if(graph[nx][ny] == 0 && !visit[nx][ny][cur.wall]) {
					visit[nx][ny][cur.wall] = true;
					q.add(new Node(nx,ny,cur.cnt+1,cur.wall));
				// 벽일 때
				} else {
					if (cur.wall < K && !visit[nx][ny][cur.wall+1]) {
						visit[nx][ny][cur.wall+1] = true;
						q.add(new Node(nx,ny,cur.cnt+1,cur.wall+1));
					}
				}
			}
		}
	}
}