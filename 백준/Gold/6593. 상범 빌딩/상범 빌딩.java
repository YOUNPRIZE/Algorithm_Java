import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int L, R, C;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static Queue<int[]> q;
	static int[][][] map;
	static boolean[][][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String LRC = br.readLine();
			String[] LRCarr = LRC.split(" ");
			if (LRC.equals("0 0 0")) break;
			L = Integer.parseInt(LRCarr[0]);
			R = Integer.parseInt(LRCarr[1]);
			C = Integer.parseInt(LRCarr[2]);
			map = new int[L][R][C];
			visit = new boolean[L][R][C];
			int sx = 0;
			int sy = 0;
			int sz = 0;
			for (int z = 0; z < L; z++) {
				for (int i = 0; i < R; i++) {
					String str = br.readLine();
					for (int j = 0; j < C; j++) {
						if (str.charAt(j) == 'S') {
							map[z][i][j] = 1;
							sx = i;
							sy = j;
							sz = z;
						} else if (str.charAt(j) == '.') {
							map[z][i][j] = 0;
						} else if (str.charAt(j) == '#') {
							map[z][i][j] = -1;
						} else if (str.charAt(j) == 'E') {
							map[z][i][j] = -2;
						}
					}
				}
				String enter = br.readLine();
			}
			//System.out.println(Arrays.deepToString(map));
			bfs(sz, sx, sy);
		}
	}
	public static void bfs(int z, int x, int y) {
		q = new LinkedList<>();
		q.add(new int[] {z, x, y});
		visit[z][x][y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 6; i++) {
				int nx = cur[1] + dx[i];
				int ny = cur[2] + dy[i];
				int nz = cur[0] + dz[i];
				if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L) continue;
				if (!visit[nz][nx][ny] && map[nz][nx][ny] == 0) {
					visit[nz][nx][ny] = true;
					map[nz][nx][ny] = map[cur[0]][cur[1]][cur[2]] + 1;
					//System.out.println(map[cur[0]][cur[1]][cur[2]] + 1);
					q.add(new int[] {nz, nx, ny});
				}
				if (!visit[nz][nx][ny] && map[nz][nx][ny] == -2) {
					System.out.printf("Escaped in %d minute(s).\n", map[cur[0]][cur[1]][cur[2]]);
					return;
				}
			}
		}
		System.out.println("Trapped!");
	}
}