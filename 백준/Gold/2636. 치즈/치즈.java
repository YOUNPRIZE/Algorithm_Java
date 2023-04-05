import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// BAEK2636. 치즈
public class Main {
	static int N, M, count;
	static int[][] graph;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> q, qSurface;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		list = new ArrayList<>();
		count = 0;
//		boolean flag = false;
		qSurface = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
//				if (graph[i][j] > 0) flag = true;
				if (graph[i][j] == 1) count++;
			}
		}
		list.add(count);
//		if (!flag) {
//			System.out.println(0);
//			System.out.println(0);
//			return;
//		}
		
		count = 0;
		
		
		
		while(true) {
			count++;
			visit = new boolean[N][M];
			findSurface();
			
			melt();
			
			if (countCheese() == 0) break;
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i : list) min = Math.min(min, i);
		
		System.out.println(count);
		System.out.println(min);
	}
	
	public static void findSurface() {
		q = new LinkedList<>();
		q.add(new int[] {0,0});
		visit[0][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (visit[nx][ny]) continue;
				if (!visit[nx][ny] && graph[nx][ny] == 1) {
					visit[nx][ny] = true;
					qSurface.add(new int[] {nx, ny});
				}
				if (graph[nx][ny] == 0) {
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
	
	public static void melt() {
		while(!qSurface.isEmpty()) {
			int[] cur = qSurface.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			graph[cx][cy] = 0;
		}
//		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(graph[i]));
	}
	
	public static int countCheese() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) if (graph[i][j] > 0) cnt++;
		}
		if (cnt != 0) list.add(cnt);
//		System.out.println(cnt);
		return cnt;
	}
}