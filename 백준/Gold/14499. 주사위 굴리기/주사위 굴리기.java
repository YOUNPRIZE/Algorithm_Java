import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//  1
	// 234
	//  5
	//  6
	static int[] dice = new int[7];
	static int N,M,x,y;
	static int[][] graph;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int d = Integer.parseInt(st.nextToken());
			move(d);
		}
		
	}
	
	static void move(int d) {
		int nx = x + dx[d-1];
		int ny = y + dy[d-1];
		if(nx <0 || ny < 0 || nx > M-1 || ny > N-1) return;
		roll(d, nx, ny);
		x = nx; y = ny;
		
	}

	// 1 2 3 4 (동 서 남 북)
	static void roll(int d, int x, int y) {
		int tmp = dice[3];
		switch(d) {
		case 1:
			dice[3] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 2:
			dice[3] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3:
			dice[3] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[1];
			dice[1] = tmp;
			break;
		case 4:
			dice[3] = dice[1];
			dice[1] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
		if(graph[y][x] == 0) {
			graph[y][x] = dice[6];
		} else {
			dice[6] = graph[y][x];
			graph[y][x] =0;
		}
		System.out.println(dice[3]);
		
	}
}