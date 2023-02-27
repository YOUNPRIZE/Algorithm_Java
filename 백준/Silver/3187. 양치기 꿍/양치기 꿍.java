import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R,C;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cntSheep, liveSheep;
	static int cntWolf, liveWolf;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		R = Integer.parseInt(strArr[0]);
		C = Integer.parseInt(strArr[1]);
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		liveSheep = 0;
		liveWolf = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.' && !visit[i][j]) {
					cntSheep = 0;
					cntWolf = 0;
					dfs(i, j);
					if (cntWolf >= cntSheep) liveWolf += cntWolf;
					else liveSheep += cntSheep;
				}
				else if(map[i][j] == 'v' && !visit[i][j]) {
					cntSheep = 0;
					cntWolf = 1;
					dfs(i, j);
					if (cntWolf >= cntSheep) liveWolf += cntWolf;
					else liveSheep += cntSheep;
				}
				else if(map[i][j] == 'k' && !visit[i][j]) {
					cntSheep = 1;
					cntWolf = 0;
					dfs(i, j);
					if (cntWolf >= cntSheep) liveWolf += cntWolf;
					else liveSheep += cntSheep;
				}
			}
		}
		
		System.out.printf("%d %d", liveSheep, liveWolf);
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			if (visit[nx][ny]) continue;
			if (map[nx][ny] == '.') {
				dfs(nx, ny);
			} else if (map[nx][ny] == 'v') {
				cntWolf++;
				dfs(nx, ny);
			} else if (map[nx][ny] == 'k') {
				cntSheep++;
				dfs(nx, ny);
			}
		}
	}
}