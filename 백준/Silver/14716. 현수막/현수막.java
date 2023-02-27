import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] arr;
	static int[][] visit;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		M = Integer.parseInt(strArr[0]);
		N = Integer.parseInt(strArr[1]);
		arr = new int[M][N];
		visit = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0 && arr[i][j] == 1) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	public static void dfs(int x, int y) {
		visit[x][y] = 1;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
			if (visit[nx][ny] == 0 && arr[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}