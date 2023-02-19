import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static LinkedList<int[]> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = (arr[i][j] > max) ? arr[i][j] : max;
			}
		}
		
		int safeArea = 0;
		
		for (int i = 0; i < max; i++) {
			if (bfs(i) >= safeArea) safeArea = bfs(i);
		}
		System.out.println(safeArea);
	}
	public static int bfs(int height) {
		int[][] visit = new int[N][N];
		
		q = new LinkedList<>();
		
		int cnt = 0;
		int area = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > height && visit[i][j] == 0) {
					q.add(new int[] {i,j});
					visit[i][j] = 1;
					cnt++;
					while (!q.isEmpty()) {
						int[] ele = q.remove();
						for (int k = 0; k < 4; k++) {
							int x = ele[0] + dx[k];
							int y = ele[1] + dy[k];
							
							if (x < 0 || x >= N || y < 0 || y >= N) continue;
							if (arr[x][y] > height && visit[x][y] == 0) {
								visit[x][y] = 1;
								q.add(new int[] {x, y});
							}
						}
					}
				}
				if (cnt > 0) {
					area++;
					cnt = 0;
				}
			}
		}
		return area;
	}
}
