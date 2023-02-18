
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int M,N;
	static int[][] arr;
	static LinkedList<int[]> q;
	
	// 상, 하, 좌, 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 토마토가 익었으면 큐에 넣기
				if (arr[i][j] == 1) q.add(new int[] {i,j});
			}
		}
		System.out.println(bfs());
	}
	
	public static int bfs() {
		while(!q.isEmpty()) {
			int[] element = q.remove();
			for (int i = 0; i < 4; i++) {
				int x = element[0] + dx[i];
				int y = element[1] + dy[i];
				if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (arr[x][y] == 0) {
                    arr[x][y] = arr[element[0]][element[1]] + 1;
                    q.add(new int[]{x, y});
                }
//				if (x >= 0 && x < N && y >= 0 && y < M && arr[x][y] == 0) {
//					q.push(new int[] {x, y});
//					arr[x][y] = arr[element[0]][element[1]] + 1;
//					
//				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) return -1;
				if (result < arr[i][j]) result = arr[i][j];
			}
		}
		
		return result - 1;
		
//		if (result == 1) return 0;
//		else return result-1;
	}
}
