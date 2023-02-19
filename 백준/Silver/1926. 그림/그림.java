import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		LinkedList<int[]> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 상, 하, 좌, 우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int[][] arr = new int[N][M];
		int[][] visit = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sum = 0;
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if(arr[i][j] == 1 && visit[i][j] == 0) {
					int cnt = 0;
					q.add(new int[]{i, j});
					
					visit[i][j] = 1;
					
					while(!q.isEmpty()) {
						int[] element = q.poll();
						cnt++;
						for(int k = 0; k < 4; k++) {
							int x = element[0] + dx[k];
							int y = element[1] + dy[k];
							if (x >= 0 && x < N && y >= 0 && y < M && visit[x][y]==0&&arr[x][y] == 1) {
								
								visit[x][y] = 1;
								
								q.add(new int[] {x,y});
							}
						}
					}
					
					if (cnt > max) max = cnt;
					
					sum++;
				}
			}
		}
		
		System.out.println(sum);
		System.out.println(max);
	}
}
