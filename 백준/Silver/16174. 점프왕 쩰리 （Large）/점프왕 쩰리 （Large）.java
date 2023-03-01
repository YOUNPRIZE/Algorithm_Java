import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	static Queue<int[]> q;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0, 0);
	}
	
	public static void bfs(int x, int y) {
		q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == N-1 && cur[1] == N-1) {
				System.out.println("HaruHaru");
				return;
			}
			for (int i = 0; i< 2; i++) {
				int nx = cur[0] + map[cur[0]][cur[1]] * dx[i];
				int ny = cur[1] + map[cur[0]][cur[1]] * dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if (!visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
		System.out.println("Hing");
	}
}