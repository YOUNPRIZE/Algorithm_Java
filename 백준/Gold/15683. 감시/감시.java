import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Camera {
		int x;
		int y;
		int kind;
		public Camera(int x, int y, int kind) {
			this.x = x;
			this.y = y;
			this.kind = kind;
		}
	}
	
	static int N,M;
	static int answer = Integer.MAX_VALUE;
	static int[][] graph, copyGraph;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<Camera> list;
	static int[] output;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
//				if (graph[i][j] == 6) graph[i][j] = -1;
				if (graph[i][j] >= 1 && graph[i][j] <= 5) list.add(new Camera(i, j, graph[i][j]));
			}
		}
		output = new int[list.size()];
		dfs(0, list.size());
		System.out.println(answer);
	}
	public static void dfs(int depth, int r) {
		// base case
		if (depth == r) {
			copyGraph = new int[N][M];
			
//			for (int i = 0; i < N; i++) copyGraph[i] = graph[i].clone();
			for(int i = 0; i < graph.length; i++) {
				System.arraycopy(graph[i], 0, copyGraph[i], 0, graph[i].length);
			}
			for (int i = 0; i < list.size(); i++) {
				direction(list.get(i), output[i]);
			}
			
			getBlindSpot();
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			output[depth] = i;
			dfs(depth+1, r);
		}
	}
	public static void direction(Camera camera, int d) {
		int cctvNum = camera.kind;

		if(cctvNum == 1) {
			if(d == 0) watch(camera, 0); // 상 
			else if(d == 1) watch(camera, 1); // 우 
			else if(d == 2) watch(camera, 2); // 하  
			else if(d == 3) watch(camera, 3); // 좌 
		} else if(cctvNum == 2) {
			if(d == 0 || d == 2) {
				watch(camera, 0); watch(camera, 2); // 상하 
			} else {
				watch(camera, 1); watch(camera, 3); // 좌우 
			}
		} else if(cctvNum == 3) {
			if(d == 0) {
				watch(camera, 0); // 상우 
				watch(camera, 1);
			} else if(d == 1) { 
				watch(camera, 1); // 우하 
				watch(camera, 2);
			} else if(d == 2) { 
				watch(camera, 2); // 하좌 
				watch(camera, 3);
			} else if(d == 3) { 
				watch(camera, 0); // 좌상 
				watch(camera, 3);
			}
		} else if(cctvNum == 4) {
			if(d == 0) {
				watch(camera, 0); // 좌상우 
				watch(camera, 1);
				watch(camera, 3);
			} else if(d == 1) {
				watch(camera, 0); // 상우하 
				watch(camera, 1);
				watch(camera, 2);
			} else if(d == 2) {
				watch(camera, 1); // 좌하우 
				watch(camera, 2);
				watch(camera, 3);
			} else if(d == 3) {
				watch(camera, 0); // 상좌하 
				watch(camera, 2);
				watch(camera, 3);
			}
		} else if(cctvNum == 5) { // 상우하좌
			watch(camera, 0);
			watch(camera, 1);
			watch(camera, 2);
			watch(camera, 3);
		}
	}
	public static void watch(Camera camera, int d) {
		Queue<Camera> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		queue.add(camera);
		visited[camera.x][camera.y] = true;

		while(!queue.isEmpty()) {
			int nx = queue.peek().x + dx[d];
			int ny = queue.poll().y + dy[d];

			// 범위를 벗어나거나 벽을 만나면 끝 
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || copyGraph[nx][ny] == 6) { 
				break;
			}

			if(copyGraph[nx][ny] == 0) { 
				copyGraph[nx][ny] = -1; // 빈칸이라면 감시할 수 있다는 의미로 -1 
				queue.add(new Camera(nx, ny, camera.kind));
			} else { // 다른 cctv가 있거나 이미 감시된 칸이라면 
				queue.add(new Camera(nx, ny, camera.kind)); // 그냥 통과 
			}
		}
	}
	public static void getBlindSpot() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyGraph[i][j] == 0) {
					cnt++;
				}
			}
		}
		answer = Math.min(answer, cnt);
	}
}