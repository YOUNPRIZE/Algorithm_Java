import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,M,cnt;
	static char[][] arr;
	static int[][] visit; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new char[N][M];
		visit = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String ele = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = ele.charAt(j); 
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] == 0) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = 1;
		int d[] = {-1, 1};
		for (int i = 0; i < 2; i++) {
			int nx = x;
			int ny = y;
			if (arr[x][y] == '|') nx += d[i];
			else ny += d[i];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if (arr[nx][ny] != arr[x][y]) continue;
			if (visit[nx][ny] == 1) continue;
			dfs(nx, ny);
		}
	}
}