import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M,N,H;
	static int[][][] arr;
	static int[][][] visit;
	static Queue<int[]> q;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		arr = new int[H][N][M];
		//visit = new int[H][N][M];
		boolean check = true;
		for (int k = 0; k < H; k++) {	
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {	
					arr[k][i][j] = Integer.parseInt(st.nextToken());
					if (arr[k][i][j] == 0) check = false;
					if (arr[k][i][j] == 1) q.add(new int[] {i, j, k});
				}
			}
		}
		if (check) {
			System.out.println(0);
			return;
		}
		
		System.out.println(bfs());
	}
 	
 	public static int bfs() {
 		while(!q.isEmpty()) {
 			int[] element = q.poll();
 			for (int i = 0; i < 6; i++) {
 				int nx = element[0] + dx[i];
 				int ny = element[1] + dy[i];
 				int nz = element[2] + dz[i];
 				
 				if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
 				if (arr[nz][nx][ny] == 0) {
 					//visit[nz][nx][ny] = 1;
 					arr[nz][nx][ny] = arr[element[2]][element[0]][element[1]] + 1;
 					q.add(new int[] {nx, ny, nz});
 				}
 			}
 		}
 		
 		int max = Integer.MIN_VALUE;
		
 		for (int k = 0; k < H; k++) {	
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[k][i][j] == 0) return -1;
					if (arr[k][i][j] > max) max = arr[k][i][j]; 
				}
			}
		}
		return max - 1;
 	}
}
