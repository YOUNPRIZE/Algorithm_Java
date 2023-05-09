import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static int max = Integer.MIN_VALUE;
	static Deque<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, graph);
		System.out.println(max);
//		up(graph);
	}
	
	public static void dfs(int cnt, int[][] map) {
		// base case
		if (cnt == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, map[i][j]);
				}
			}
			return;
		}
		// recur case
		dfs(cnt + 1, left(map));
		dfs(cnt + 1, right(map));
		dfs(cnt + 1, up(map));
		dfs(cnt + 1, down(map));
	}
	
	public static int[][] left(int[][] map) {
		int[][] temp = new int[N][N];
		
		for (int i = 0; i < N; i++) temp[i] = map[i].clone();
		
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if (temp[i][j] != 0) {
					if (!q.isEmpty() && q.peekLast() == temp[i][j] && !flag) {
						q.addLast(q.pollLast() * 2);
						flag = true;
					} else {
						q.add(temp[i][j]);
						flag = false;
					}
					temp[i][j] = 0;
				}
			}
			int idx = 0;
			while(!q.isEmpty()) {
				temp[i][idx++] = q.pollFirst();
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				max = Math.max(max, temp[i][j]);
//			}
//		}
		
//		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(temp[i]));
		
		return temp;
	}
	
	public static int[][] right(int[][] map) {
		int[][] temp = new int[N][N];
		
		for (int i = 0; i < N; i++) temp[i] = map[i].clone();
		
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			for (int j = N-1; j >= 0; j--) {
				if (temp[i][j] != 0) {
					if (!q.isEmpty() && q.peekLast() == temp[i][j] && !flag) {
						q.addLast(q.pollLast() * 2);
						flag = true;
					} else {
						q.add(temp[i][j]);
						flag = false;
					}
					temp[i][j] = 0;
				}
			}
			int idx = N-1;
			while(!q.isEmpty()) {
				temp[i][idx--] = q.pollFirst();
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				max = Math.max(max, temp[i][j]);
//			}
//		}
//		
//		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(temp[i]));
		
		return temp;
	}
	
	public static int[][] up(int[][] map) {
		int[][] temp = new int[N][N];
		
		for (int i = 0; i < N; i++) temp[i] = map[i].clone();
		
		for (int j = 0; j < N; j++) {
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (temp[i][j] != 0) {
					if (!q.isEmpty() && q.peekLast() == temp[i][j] && !flag) {
						q.addLast(q.pollLast() * 2);
						flag = true;
					} else {
						q.add(temp[i][j]);
						flag = false;
					}
					temp[i][j] = 0;
				}
			}
			int idx = 0;
			while(!q.isEmpty()) {
				temp[idx++][j] = q.pollFirst();
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				max = Math.max(max, temp[i][j]);
//			}
//		}
//		
//		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(temp[i]));
		
		return temp;
	}
	
	public static int[][] down(int[][] map) {
		int[][] temp = new int[N][N];
		
		for (int i = 0; i < N; i++) temp[i] = map[i].clone();
		
		for (int j = 0; j < N; j++) {
			boolean flag = false;
			for (int i = N - 1; i >= 0; i--) {
				if (temp[i][j] != 0) {
					if (!q.isEmpty() && q.peekLast() == temp[i][j] && !flag) {
						q.addLast(q.pollLast() * 2);
						flag = true;
					} else {
						q.add(temp[i][j]);
						flag = false;
					}
					temp[i][j] = 0;
				}
			}
			int idx = N - 1;
			while(!q.isEmpty()) {
				temp[idx--][j] = q.pollFirst();
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				max = Math.max(max, temp[i][j]);
//			}
//		}
//		
//		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(temp[i]));
		
		return temp;
	}
}