import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, H, W;
	static boolean[][] visit;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> q;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().split(" ");
			H = Integer.parseInt(input[0]);
			W = Integer.parseInt(input[1]);
			
			map = new char[H][W];
			visit = new boolean[H][W];
			
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visit[i][j] && map[i][j] == '#') {
						bfs(new int[] {i, j});
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static void bfs(int[] cur) {
		q = new LinkedList<>();
		q.add(cur);
		visit[cur[0]][cur[1]] = true;
		while(!q.isEmpty()) {
			int[] ele = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = ele[0] + dx[i];
				int ny = ele[1] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
				if (!visit[nx][ny] && map[nx][ny] == '#') {
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
		cnt++;
	}
}