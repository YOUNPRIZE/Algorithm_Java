import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,d,s;
	static int[][] graph;
	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] cx = {0, 0, 1, 1};
	static int[] cy = {0, 1, 0, 1};
	static int[] dgx = {-1, -1, 1, 1};
	static int[] dgy = {-1, 1, -1, 1};
	static int[] start;
	static boolean[][] visit;
	static Queue<int[]> cloud = new LinkedList<>();
//	static Queue<int[]> temp = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cloud.add(new int[] {N-2, 0});
		cloud.add(new int[] {N-2, 1});
		cloud.add(new int[] {N-1, 0});
		cloud.add(new int[] {N-1, 1});
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			// 1. 모든 구름이 d방향으로 s칸 이동한다.
			int size = cloud.size();
			for (int k = 0; k < size; k++) {
				int[] coord = cloud.poll();
				int x = coord[0];
				int y = coord[1];
				int[] next = move(x, y);
				cloud.add(next);
			}
			
			// 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
			for (int k = 0; k < size; k++) {
				int[] coord = cloud.poll();
				int x = coord[0];
				int y = coord[1];
				graph[x][y]++;
				int[] next = new int[] {x, y};
				cloud.add(next);
			}
			// 3. 구름이 모두 사라진다.
			
			// 4. 물복사버그 마법을 시전
			for (int k = 0; k < size; k++) {
				int[] coord = cloud.poll();
				int x = coord[0];
				int y = coord[1];
			
				int backet = 0;
				
				for (int j = 0; j < 4; j++) {
					int nnx = x + dgx[j];
					int nny = y + dgy[j];
					if (nnx < 0 || nny < 0 || nnx >= N || nny >= N) continue;
					if (graph[nnx][nny] > 0) backet++;
				}
				graph[x][y] += backet;
				cloud.add(new int[] {x, y});
			}
			// 5.
			visit = new boolean[N][N];
			while(!cloud.isEmpty()) {
				int[] cur = cloud.poll();
				visit[cur[0]][cur[1]] = true;
			}
			
			for (int p = 0; p < N; p++) {
				for (int q = 0; q < N; q++) {
					if (!visit[p][q] && graph[p][q] >= 2) {
						graph[p][q] -= 2;
						cloud.add(new int[] {p,q});
					}
					
//					boolean flag = false;
//					for (int e = 0; e < size; e++) {
//						int[] cur = cloud.poll();
//						if (p == cur[0] && q == cur[1]) flag = true;
//						cloud.add(cur);
//					}
//					if (!flag) {
//						if (graph[p][q] >= 2) {
//							temp.add(new int[] {p,q});
//							graph[p][q] -= 2;
//						}
//					}
				}
			}
//			while(!cloud.isEmpty()) cloud.poll();
//			while(!temp.isEmpty()) cloud.add(temp.poll());
		}
		
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += graph[i][j];
			}
		}
		System.out.println(ans);
	}
	
	// 구름 이동
	public static int[] move(int x, int y) {
		int movetoX = dx[d-1];
		int movetoY = dy[d-1];
		int nx = x + movetoX * s;
		int ny = y + movetoY * s;
		
		if (nx >= N) {
			nx = nx % N;
		} else if (nx < 0) {
			int temp = Math.abs(nx);
			temp = temp % N;
			nx = N - temp;
			if (nx == N) nx = 0;
		}
		
		if (ny >= N) {
			ny = ny % N;
		} else if (ny < 0) {
			int temp = Math.abs(ny);
			temp = temp % N;
			ny = N - temp;
			if (ny == N) ny = 0;
		}
		
		int[] moved = new int[] {nx, ny};
		return moved;
	}
}