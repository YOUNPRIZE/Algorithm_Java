import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, idx, dist, result;
	static int[][] graph;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Coord> q = new LinkedList<>();
	static class Coord {
		int x;
		int y;
		int cnt;
		public Coord(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && graph[i][j] == 1) {
					bfs(i,j);
					idx++;
				}
			}
		}
		//for (int i = 0; i < N; i++) System.out.println(Arrays.toString(graph[i]));
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] >= 1) {
					visit = new boolean[N][N];
					bfs2(i,j);
				}
			}
		}
		System.out.println(result);
	}
	
	public static void bfs(int x, int y) {
		q.add(new Coord(x,y,0));
		visit[x][y] = true;
		graph[x][y] = idx;
		while(!q.isEmpty()) {
			Coord curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if (!visit[nx][ny] && graph[nx][ny] == 1) {
					visit[nx][ny] = true;
					graph[nx][ny] = idx;
					q.add(new Coord(nx, ny, 0));
				}
			}
		}
	}
	
	public static void bfs2(int x, int y) {
		q.add(new Coord(x, y, 0));
		int curNum = graph[x][y];
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Coord coord = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = coord.x + dx[i];
				int ny = coord.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if (!visit[nx][ny] && graph[nx][ny] != curNum) {
					visit[nx][ny] = true;
					if (graph[nx][ny] == 0) q.add(new Coord(nx, ny, coord.cnt + 1));
					else result = Math.min(result, coord.cnt);
				}
			}
		}
	}
}