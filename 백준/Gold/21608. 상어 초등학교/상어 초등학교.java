import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map, favorite;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static class Node implements Comparable<Node>{
		int x, y, like, blank;
		public Node (int x, int y, int like, int blank) {
			this.x = x;
			this.y = y;
			this.like = like;
			this.blank = blank;
		}
		
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (like == o.like) {
				if (blank == o.blank) {
					if (x == o.x) {
						return y - o.y;
					}
					return x - o.x;
				}
				return o.blank - blank;
			}
			return o.like - like;
		}
		
	}
	static PriorityQueue<Node> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		favorite = new int[N * N + 1][5];
		StringTokenizer st;
		for (int i = 1; i <= N*N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				favorite[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int j = 0; j <= N*N; j++) System.out.println(Arrays.toString(favorite[j]));
		
		for (int i = 1; i <= N * N; i++) {
			if (i == 1) {
				map[2][2] = favorite[i][0];
			} else {
				location(favorite[i]);
//				for (int j = 0; j <= N; j++) System.out.println(Arrays.toString(map[j]));
			}
		}
		
		int res = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cnt = 0;
				for (int k = 1; k <= N * N; k++) {
					if (map[i][j] == favorite[k][0]) {
						for (int p = 0; p < 4; p++) {
							int nx = i + dx[p];
							int ny = j + dy[p];
							if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
							for (int q = 1; q <= 4; q++) {
								if (map[nx][ny] == favorite[k][q]) {
									cnt++;
									break;
								}
							}
						}
						break;
					}
				}
				if (cnt >= 1) {
					if (cnt == 1) res += 1;
					else if (cnt == 2) res += 10;
					else if (cnt == 3) res += 100;
					else res += 1000;
				}
			}
		}
		
		System.out.println(res);
	}
	public static void location(int[] favor) {
		pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 0) {
					int like = 0;
					int blank = 0;
					int cx = i;
					int cy = j;
					for (int k = 0; k < 4; k++) {
						int nx = cx + dx[k];
						int ny = cy + dy[k];
						if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
						if (map[nx][ny] == 0) blank++;
						else {
							for (int idx = 1; idx < 5; idx++) {
								if (map[nx][ny] == favor[idx]) {
									like++;
									break;
								}
							}
						}
					}
//					System.out.println("x : " + cx + " " + "y : " + cy + " " + "like : " + like + " " + "blank : " + blank);
					pq.add(new Node(cx, cy, like, blank));
				}
			}
		}
		Node node = pq.poll();
//		System.out.println(node.x + " " + node.y + " " + node.like + " " + node.blank);
		map[node.x][node.y] = favor[0];
	} 
}