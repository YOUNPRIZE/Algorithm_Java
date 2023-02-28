import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int M,N;
	static char[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean check = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MN = br.readLine().split(" ");
		M = Integer.parseInt(MN[0]);
		N = Integer.parseInt(MN[1]);
		map = new char[M][N];
		visit = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (!visit[0][i] && map[0][i] == '0') bfs(0, i); 
		}

		if (check) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static void bfs(int x, int y) {
		q = new LinkedList<>();
		q.add(new int[] {x, y});
		//boolean check = false;
		visit[x][y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == M - 1) {
				check = true;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if (!visit[nx][ny] && map[nx][ny] == '0') {
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
}