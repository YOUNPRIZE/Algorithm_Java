import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] graph;
	static int N,M,cnt;
	static Queue<int[]> q;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 상근이의 동기의 수
		N = Integer.parseInt(br.readLine());
		// 리스트의 길이
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			String[] relation = br.readLine().split(" ");
			int A = Integer.parseInt(relation[0]);
			int B = Integer.parseInt(relation[1]);
			graph[A][B] = 1;
			graph[B][A] = 1;
		}
		
		
		System.out.println(bfs(1, 0));
	}
	
	public static int bfs(int num, int cnt) {
		cnt = 0;
		q = new LinkedList<>();
		q.add(new int[] {num, cnt});
		visit[num] = true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			if (temp[1] == 2) break;
			int p = temp[0];
			int count = temp[1];
			for (int i = 1; i <= N; i++) {
				if (graph[p][i] == 1 && !visit[i]) {
					visit[i] = true;
					q.add(new int[] {i, count+1});
					cnt++;
				}
			}
		}
		return cnt;
	}
}