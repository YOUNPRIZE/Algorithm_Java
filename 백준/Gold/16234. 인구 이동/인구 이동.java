import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, L, R;
	static int[][] graph;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N x N 크기의 땅
		N = Integer.parseInt(st.nextToken());
		// 두 나라의 인구 차이가 L명 이상, R명 이하
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(move());
	}
	
	public static int move() {
		int result = 0;
		while(true) {
			boolean isMove = false;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						int sum = bfs(i, j);
						if (list.size() > 1) {
							change(sum);
							isMove = true;
						}
					}
				}
			}
			if(!isMove) return result;
			result++;
		}
	}
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();
		
		q.add(new Node(x, y));
		list.add(new Node(x, y));
		visit[x][y] = true;
		
		int sum = graph[x][y];
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
					int dif = Math.abs(graph[cur.x][cur.y] - graph[nx][ny]);
					if (L <= dif && dif <= R) {
						q.add(new Node(nx, ny));
						list.add(new Node(nx, ny));
						sum += graph[nx][ny];
						visit[nx][ny] = true;
					}
				}
			}
		}
		return sum;
	}
	
	public static void change(int sum) {
		int avg = sum / list.size();
		for (Node n : list) {
			graph[n.x][n.y] = avg;
		}
	}
}