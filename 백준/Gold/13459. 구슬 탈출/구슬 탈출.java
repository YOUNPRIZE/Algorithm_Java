import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int cnt, rx, ry, bx, by;
		
		public Node(int cnt, int rx, int ry, int bx, int by) {
			super();
			this.cnt = cnt;
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}
	}
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int N, M, rx, ry, bx, by;
	static char[][] graph;
	static boolean[][][][] visit;
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		
		
		Node start;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = str.charAt(j);
				if (graph[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (graph[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}
//		start = new Node(0, rx, ry, bx, by);
		int res = bfs();
		if (res == -1) System.out.println(0);
		else System.out.println(1);
//		System.out.println(res);
	}
	
	public static int bfs() {
		visit = new boolean[10][10][10][10];
		q = new LinkedList<>();
		Node start = new Node(0, rx, ry, bx, by);
		q.add(start);
		visit[start.rx][start.ry][start.bx][start.by] = true;
		int ans = -1;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.cnt > 10) break;
			if (graph[cur.rx][cur.ry] == 'O' && graph[cur.bx][cur.by] != 'O') {
				ans = cur.cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int next_rx = cur.rx;
				int next_ry = cur.ry;
				int next_bx = cur.bx;
				int next_by = cur.by;
				
				
				
				while(true) {
					if (graph[next_rx][next_ry] != '#' && graph[next_rx][next_ry] != 'O') {
						next_rx += dx[i];
						next_ry += dy[i];
					} else {
						if (graph[next_rx][next_ry] == '#') {
							next_rx -= dx[i];
							next_ry -= dy[i];
						}
						break;
					}
				}
				
				while(true) {
					if (graph[next_bx][next_by] != '#' && graph[next_bx][next_by] != 'O') {
						next_bx += dx[i];
						next_by += dy[i];
					} else {
						if (graph[next_bx][next_by] == '#') {
							next_bx -= dx[i];
							next_by -= dy[i];
						}
						break;
					}
				}
				
				if (next_rx == next_bx && next_ry == next_by) {
					if (graph[next_rx][next_ry] != 'O') {
						int red_dist = Math.abs(next_rx - cur.rx) + Math.abs(next_ry - cur.ry);
						int blue_dist = Math.abs(next_bx - cur.bx) + Math.abs(next_by - cur.by);
						if (red_dist > blue_dist) {
							next_rx -= dx[i];
							next_ry -= dy[i];
						} else {
							next_bx -= dx[i];
							next_by -= dy[i];
						}
					}
				}
				if (!visit[next_rx][next_ry][next_bx][next_by]) {
					visit[next_rx][next_ry][next_bx][next_by] = true;
					Node next = new Node(cur.cnt+1, next_rx, next_ry, next_bx, next_by);
					q.add(next);
				}
			}
		}
		
		return ans;
	}
}