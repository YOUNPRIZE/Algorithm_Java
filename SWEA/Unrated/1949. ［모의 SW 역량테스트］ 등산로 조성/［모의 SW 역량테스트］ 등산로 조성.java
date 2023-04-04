import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class Node {
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int N, K, count, max, result;
	static int[][] graph;
	static boolean[][] visit;
	static Queue<Node> q, q2;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#"+tc+" ");
			N = sc.nextInt();
			K = sc.nextInt();
			graph = new int[N][N];
			//temp = new int[N][N];
			q2 = new LinkedList<>();
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = sc.nextInt();
					max = Math.max(graph[i][j], max);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == max) q2.add(new Node(i,j,1));
				}
			}
//			System.out.println(max);
			result = Integer.MIN_VALUE;
			cutHeight(0);
//			System.out.println(count);
			System.out.println(result);
		}
	}
	
	public static void cutHeight(int cnt) {
		// base case
		if (cnt == 1) {
			bfs();
			return;
			
		}
		
		
		// recur case
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//if (graph[i][j] == max) continue;\
				for (int l = 1; l <= K; l++) {
					graph[i][j] = graph[i][j] - l;
					cutHeight(cnt + 1);
					graph[i][j] = graph[i][j] + l;
				}
			}
		}
	}
	
public static void bfs() {
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == max) q.add(new Node (i, j, 1));
			}
		}
		for (int i = 0; i < q2.size(); i++) {
			Node node = q2.poll();
			q.add(node);
			q2.add(node);
		}
		
		
		int[][] temp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			temp[i] = graph[i].clone();
		}
		
		count = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int cx = node.x;
			int cy = node.y;
			int cCnt = node.cnt;
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if (temp[nx][ny] < temp[cx][cy]) {
					q.add(new Node(nx, ny, cCnt+1));
				} 
			}
			count = Math.max(cCnt, count);
		}
		result = Math.max(result, count);
	}
}