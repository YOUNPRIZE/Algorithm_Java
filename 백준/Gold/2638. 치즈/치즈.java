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
	static Queue<int[]> q, qSurface, qMelt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		count = 0;
		qSurface = new LinkedList<>();
		qMelt = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = 0;
		
		while(true) {
			count++;
			visit = new boolean[N][M];
//			for (int i = 0; i < N; i++) System.out.println(Arrays.toString(visit[i]));
			findSurface();
//			for (int i = 0; i < N; i++) System.out.println(Arrays.toString(visit[i]));
			melt();
//			for (int i = 0; i < N; i++) System.out.println(Arrays.toString(graph[i]));
//			System.out.println();
			if (countCheese() == 0) break;
		}
		
		System.out.println(count);
	}
	
	// 겉에 있는 치즈를 찾아서 queue에 넣는 메소드
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
	
	// 치즈를 녹이는 메소드
	public static void melt() {
//		System.out.println(qSurface.size());
		while(!qSurface.isEmpty()) {
//			for (int i = 0; i < N; i++) System.out.println(Arrays.toString(graph[i]));
//			System.out.println();
			int[] cur = qSurface.poll();
			int cx = cur[0];
			int cy = cur[1];
			int tCnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (graph[nx][ny] == 0 && visit[nx][ny]) tCnt++;
//				if (graph[nx][ny] == 0) tCnt++;
			}
//			if (tCnt >= 2) graph[cx][cy] = 0;
			if (tCnt >= 2) qMelt.add(new int[] {cx, cy});
		}
		while(!qMelt.isEmpty()) {
			int[] cur = qMelt.poll();
			int cx = cur[0];
			int cy = cur[1];
			graph[cx][cy] = 0;
		}
	}
	
	// 현재 cheese의 개수를 count 하는 메소드
	public static int countCheese() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) if (graph[i][j] > 0) cnt++;
		}
		return cnt;
	}
}