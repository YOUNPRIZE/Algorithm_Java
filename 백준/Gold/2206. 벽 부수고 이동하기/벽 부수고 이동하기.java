import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] arr;
	static int[][][] visit;
	static LinkedList<int[]> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		//arr[0][0] = 2;
		
		bfs(0, 0);
		
		//if (arr[N-1][M-1] == 0) System.out.println(-1);
		//else System.out.println(arr[N-1][M-1]-1);
	}
	public static void bfs(int x, int y) {
		q = new LinkedList<>();
		q.add(new int[] {x, y, 0});
		//visit[x][y] = 1;
		while(!q.isEmpty()) {
			int[] element = q.poll();
			if (element[0] == N - 1 && element[1] == M - 1) {
				System.out.println(arr[element[0]][element[1]] + 1);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = element[0] + dx[i];
				int ny = element[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				// 1을 제외한 다른 숫자 만났을 때
				//if (visit[nx][ny] == 0 && arr[nx][ny] != 1) {
				if (arr[nx][ny] != 1) {
					if(visit[nx][ny][element[2]] == 0) {
						visit[nx][ny][element[2]] = 1;
						arr[nx][ny] = arr[element[0]][element[1]] + 1;
						q.add(new int[] {nx, ny, element[2]});
					}
				// 1 만났을 때
				//} else if (visit[nx][ny] == 0 && arr[nx][ny] == 1) {
				} else if (arr[nx][ny] == 1) {
					if(element[2] == 0 && visit[nx][ny][1] == 0) {
						visit[nx][ny][element[2]] = 1;
						arr[nx][ny] = arr[element[0]][element[1]] + 1;
						q.add(new int[] {nx, ny, 1});
					}
					//canBreakTheWall = false;
				}
			}
		}
		System.out.println(-1);
	}
	
	
//	public static void bfs(int x, int y) {
//		q = new LinkedList<>();
//		q.add(new int[] {x, y});
//		visit[x][y] = 1;
//		boolean canBreakTheWall = true;
//		while(!q.isEmpty()) {
//			int[] element = q.poll();
//			if (canBreakTheWall) {
//				for (int i = 0; i < 4; i++) {
//					int nx = element[0] + dx[i];
//					int ny = element[1] + dy[i];
//					
//					if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
//					if (visit[nx][ny] == 0 && arr[nx][ny] != 1) {
//						if (arr[nx][ny] == 0 || arr[nx][ny] > arr[element[0]][element[1]] + 1) {
//							visit[nx][ny] = 1;
//							arr[nx][ny] = arr[element[0]][element[1]] + 1;
//							q.add(new int[] {nx, ny});
//						}
//					} else if (visit[nx][ny] == 0 && arr[nx][ny] == 1) {
//						canBreakTheWall = false;
//						visit[nx][ny] = 1;
//						arr[nx][ny] = arr[element[0]][element[1]] + 1;
//						q.add(new int[] {nx, ny});
//					}
//				}
//			} else {
//				for (int i = 0; i < 4; i++) {
//					int nx = element[0] + dx[i];
//					int ny = element[1] + dy[i];
//					
//					if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
//					if (visit[nx][ny] == 0 && arr[nx][ny] != 1) {
//						if (arr[nx][ny] == 0 || arr[nx][ny] > arr[element[0]][element[1]] + 1) {
//							visit[nx][ny] = 1;
//							arr[nx][ny] = arr[element[0]][element[1]] + 1;
//							q.add(new int[] {nx, ny});
//						}
//					}
//				}
//			}
//		}
//	}
}