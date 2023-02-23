import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] arr;
	static LinkedList<int[]> q;
	static int[][] visit;
	static int[][] visitBlind;
	static int cntNormal;
	static int cntBlind;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visit = new int[N][N];
		visitBlind = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0) bfsNormal(i, j);
				if (visitBlind[i][j] == 0) bfsBlind(i, j);
			}
		}
		System.out.print(cntNormal + " " + cntBlind);
	}
	
	public static void bfsNormal(int x, int y) {
		q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = 1;
		Character color = arr[x][y];
		while(!q.isEmpty()) {
			int[] element = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = element[0] + dx[i];
				int ny = element[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (visit[nx][ny] == 0 && arr[nx][ny] == color) {
					visit[nx][ny] = 1;
					q.add(new int[] {nx, ny});
				}
			}
		}
		cntNormal++;
	}
	public static void bfsBlind(int x, int y) {
		q = new LinkedList<>();
		q.add(new int[] {x, y});
		visitBlind[x][y] = 1;
		Character color = arr[x][y];
		while(!q.isEmpty()) {
			int[] element = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = element[0] + dx[i];
				int ny = element[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (visitBlind[nx][ny] == 0) {
					if (color == 'B') {
						if (arr[nx][ny] == color) {
							visitBlind[nx][ny] = 1;
							q.add(new int[] {nx, ny});
						}
					} else {
						if (arr[nx][ny] == 'R' || arr[nx][ny] == 'G') {
							visitBlind[nx][ny] = 1;
							q.add(new int[] {nx, ny});
						}
					}
				}
			}
		}
		cntBlind++;
	}
}
