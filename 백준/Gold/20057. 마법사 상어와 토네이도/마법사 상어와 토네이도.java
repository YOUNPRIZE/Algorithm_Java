import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BAEK20057. 마법사 상어와 토네이도
public class Main {
	static int N;
	static int[][] graph;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		int start = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				start += graph[i][j];
			}
		}
		move(N/2, N/2);
		int end = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				end += graph[i][j];
			}
		}
//		System.out.println(start - end);
		System.out.println(ans);
	}
	
	public static void move(int x, int y) {
		// 0 : ←, 1 : ↓, 2 : →, 3 : ↑
		int cx = x;
		int cy = y;
		int dir = 0;
		int distance = 1;
		int change = 0;
		loop: while(true) {
			change++;
			for (int i = 0; i < distance; i++) {
				
				cx = cx + dx[dir];
				cy = cy + dy[dir];
//				System.out.println(cx + " " + cy);
				tornado(dir, cx, cy);
//				for (int j = 0; j < N; j++) System.out.println(Arrays.toString(graph[j]));
//				System.out.println();
				if (cx == 0 && cy == 0) break loop;
			}
			dir++;
			if (dir >= 4) dir = 0;
			if (change >= 2) {
				distance++;
				change = 0;
			}
		}
	}
	public static void tornado(int dir, int nx, int ny) {
		// 왼쪽 방향일 때
		if (dir == 0) {
			int total = 0;
			int blank = 2;
			for (int i = nx - 2; i <= nx + 2; i++) {
				for (int j = ny - 2; j <= ny + 2; j++) {
					if (j >= ny - 2 + blank && j <= ny + 2 - blank) {
						// 2%
						if (i == nx - 2 || i == nx + 2) {
							int perc = (graph[nx][ny] * 2) / 100;
							total += perc;
							// 벗어나지 않았을 때
							if (!escape(i, j)) graph[i][j] += perc;
							else ans += perc;
						// 5%
						} else if (i == nx) {
							if (j == ny - 2) {
								int perc = (graph[nx][ny] * 5) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						} else {
							// 10%
							if (j == ny - 1) {
								int perc = (graph[nx][ny] * 10) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							// 7%
							} else if (j == ny) {
								int perc = (graph[nx][ny] * 7) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							// 1%
							} else {
								int perc = (graph[nx][ny] * 1) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						}
					}
				}
				if (i < nx) blank--;
				else blank++;
			}
			if (!escape(nx, ny-1)) graph[nx][ny-1] += graph[nx][ny] - total;
			else ans += graph[nx][ny] - total;
			graph[nx][ny] = 0;
		// 아래 방향일 때
		} else if (dir == 1) {
			int total = 0;
			int blank = 2;
			for (int i = nx - 2; i <= nx + 2; i++) {
				for (int j = ny - 2; j <= ny + 2; j++) {
					if (j >= ny - 2 + blank && j <= ny + 2 - blank) {
						// 5%
						if (i == nx + 2) {
							int perc = (graph[nx][ny] * 5) / 100;
							total += perc;
							// 벗어나지 않았을 때
							if (!escape(i, j)) graph[i][j] += perc;
							else ans += perc;
						// 1%
						} else if (i == nx - 1) {
							if (j == ny - 1 || j == ny + 1) {
								int perc = (graph[nx][ny] * 1) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						// 2% 랑 7%
						} else if (i == nx) {
							// 2%
							if (j == ny - 2 || j == ny + 2) {
								int perc = (graph[nx][ny] * 2) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							// 7%
							} else if (j == ny - 1 || j == ny + 1) {
								int perc = (graph[nx][ny] * 7) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						} else if (i == nx + 1) {
							// 10%
							if (j == ny - 1 || j == ny + 1) {
								int perc = (graph[nx][ny] * 10) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						}
					}
				}
				if (i < nx) blank--;
				else blank++;
			}
			if (!escape(nx+1, ny)) graph[nx+1][ny] += graph[nx][ny] - total;
			else ans += graph[nx][ny] - total;
			graph[nx][ny] = 0;
		// 오른쪽 방향일 때
		} else if (dir == 2) {
			int total = 0;
			int blank = 2;
			for (int i = nx - 2; i <= nx + 2; i++) {
				
				for (int j = ny - 2; j <= ny + 2; j++) {
					if (j >= ny - 2 + blank && j <= ny + 2 - blank) {
						// 2%
						if (i == nx - 2 || i == nx + 2) {
							int perc = (graph[nx][ny] * 2) / 100;
							total += perc;
							// 벗어나지 않았을 때
							if (!escape(i, j)) graph[i][j] += perc;
							else ans += perc;
						// 5%
						} else if (i == nx) {
							if (j == ny + 2) {
								int perc = (graph[nx][ny] * 5) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						} else {
							// 1%
							if (j == ny - 1) {
								int perc = (graph[nx][ny] * 1) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							// 7%
							} else if (j == ny) {
								int perc = (graph[nx][ny] * 7) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							// 10%
							} else {
								int perc = (graph[nx][ny] * 10) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						}
					}
				}
				if (i < nx) blank--;
				else blank++;
			}
			if (!escape(nx, ny+1)) graph[nx][ny+1] += graph[nx][ny] - total;
			else ans += graph[nx][ny] - total;
			graph[nx][ny] = 0;
		// 위쪽 방향일 때
		} else {
			int total = 0;
			int blank = 2;
			for (int i = nx - 2; i <= nx + 2; i++) {
				
				for (int j = ny - 2; j <= ny + 2; j++) {
					if (j >= ny - 2 + blank && j <= ny + 2 - blank) {
						// 5%
						if (i == nx - 2) {
							int perc = (graph[nx][ny] * 5) / 100;
							total += perc;
							// 벗어나지 않았을 때
							if (!escape(i, j)) graph[i][j] += perc;
							else ans += perc;
						// 10%
						} else if (i == nx - 1) {
							if (j == ny - 1 || j == ny + 1) {
								int perc = (graph[nx][ny] * 10) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						// 2% 랑 7%
						} else if (i == nx) {
							// 2%
							if (j == ny - 2 || j == ny + 2) {
								int perc = (graph[nx][ny] * 2) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							// 7%
							} else if (j == ny - 1 || j == ny + 1) {
								int perc = (graph[nx][ny] * 7) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						} else if (i == nx + 1) {
							// 1%
							if (j == ny - 1 || j == ny + 1) {
								int perc = (graph[nx][ny] * 1) / 100;
								total += perc;
								// 벗어나지 않았을 때
								if (!escape(i, j)) graph[i][j] += perc;
								else ans += perc;
							}
						}
					}
				}
				if (i < nx) blank--;
				else blank++;
			}
			if (!escape(nx-1, ny)) graph[nx-1][ny] += graph[nx][ny] - total;
			else ans += graph[nx][ny] - total;
			graph[nx][ny] = 0;
		}
	}
	public static boolean escape(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) return true;
		else return false;
	}
}