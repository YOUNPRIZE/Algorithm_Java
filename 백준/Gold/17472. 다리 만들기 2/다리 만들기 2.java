import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node2 implements Comparable<Node2> {
		int x; // from
		int y; // to
		int cnt;
		public Node2(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node2 o) {
			// TODO Auto-generated method stub
			return cnt - o.cnt;
		}
	}
	static int N, M, idx;
	static int[][] graph;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] parent;
	static Queue<int[]> q;
	static PriorityQueue<Node2> qConn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visit = new boolean[N][M];
		q = new LinkedList<>();
		qConn = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) graph[i][j] = Integer.parseInt(st.nextToken());
		}
		idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] >= 1  && !visit[i][j]) {
					divideIsland(i, j);
					idx++;
				}
			}
		}
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] >= 1) connectIsland(i, j, graph[i][j]);
			}
		}
		
		// 밑은 크루스칼 알고리즘 구현부
		parent = new int[idx];
		
		for (int i = 1; i < idx; i++) {
			parent[i] = i;
		}
		
		int len = 0;
		int count = 0;
		while(!qConn.isEmpty()) {
			Node2 node = qConn.poll();
			int from = node.x;
			int to = node.y;
			int leng = node.cnt;
			if (find(from) != find(to)) {
				union(from, to);
				len += leng;
				count++;
			}
		}
		if (len == 0 || count != idx - 2) System.out.println(-1);
		else System.out.println(len);
	}
	// 섬 구역 나누기
	public static void divideIsland(int x, int y) {
		q.add(new int[] {x, y});
		visit[x][y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			graph[cx][cy] = idx;
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) continue;
				if (graph[nx][ny] == 1) {
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
	// 섬 연결 해주기
	public static void connectIsland(int x, int y, int num) {
		int cx = x;
		int cy = y;
		int length = 0;
		for (int i = 0; i < 4; i++) {
			while(true) {
				cx = cx + dx[i];
				cy = cy + dy[i];
				if (cx >= 0 && cy >= 0 && cx < N && cy < M) {
					// 현재랑 같을때
					if (graph[cx][cy] == num) {
						cx = x;
						cy = y;
						length = 0;
						break;
					}
					// 0일 때
					else if (graph[cx][cy] == 0) length++;
					else {
						// 1보다 크면 pq에 추가
						if (length > 1) {
							qConn.add(new Node2(num, graph[cx][cy], length));
						}
						cx = x;
						cy = y;
						length = 0;
						break;
					}
				} else {
					cx = x;
					cy = y;
					length = 0;
					break;
				}
			}
		}
	}
	public static int find(int v) {
		if (parent[v] == v) return v;
		else return find(parent[v]);
	}
	
	public static void union(int x, int y) {
		if (x < y) parent[find(y)] = find(x);
		else if (x > y) parent[find(x)] = find(y);
	}
}