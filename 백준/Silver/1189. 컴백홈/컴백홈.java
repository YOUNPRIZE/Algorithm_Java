import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,K,total;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		total = 0;
		visit[R-1][0] = true;
		dfs(R-1, 0, 1);
		System.out.println(total);
	}
	
	public static void dfs(int x, int y, int cnt) {
		
		if (cnt > K) return;
		if (x == 0 && y == C-1 && cnt == K) {
			total++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			if (map[nx][ny] == 'T') continue;
			if (visit[nx][ny]) continue;
			visit[nx][ny] = true;
			dfs(nx, ny, cnt+1);
			visit[nx][ny] = false;
		}
	}
}