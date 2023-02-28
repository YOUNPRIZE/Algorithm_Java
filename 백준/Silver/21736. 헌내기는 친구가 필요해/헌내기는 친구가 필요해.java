import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N,M;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		map = new char[N][M];
		visit = new boolean[N][M];
		
		int cx = 0;
		int cy = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					cx = i;
					cy = j;
				}
			}
		}
		bfs(cx, cy);
	}
	
	public static void bfs(int x, int y) {
		int cnt = 0;
		q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (!visit[nx][ny] && map[nx][ny] == 'O') {
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				} else if (!visit[nx][ny] && map[nx][ny] == 'P') {
					visit[nx][ny] = true;
					cnt++;
					q.add(new int[] {nx, ny});
				}
			}
		}
		if (cnt > 0) System.out.println(cnt);
		else System.out.println("TT");
	}
}