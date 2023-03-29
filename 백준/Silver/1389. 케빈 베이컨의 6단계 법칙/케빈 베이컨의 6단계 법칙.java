import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,level,bacon,who;
	static boolean[] visit;
	static int[][] graph;
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A][B] = 1;
			graph[B][A] = 1;
		}
		int min = Integer.MAX_VALUE;
		who = 0;
		q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N+1];
			visit[i] = true;
			level = 1;
			bacon = 0;
			for (int j = 1; j <= N; j++) {
				if (!visit[j] && graph[i][j] == 1) {
					q.add(new int[] {j,level});	
				}
			}
			
			while(!q.isEmpty()) {
				int[] ele = q.poll();
				if (!visit[ele[0]]) bacon += ele[1];
				visit[ele[0]] = true;
				for (int k = 1; k <= N; k++) {
					if (!visit[k] && graph[ele[0]][k] == 1) {
						q.add(new int[] {k, ele[1]+1});
					}
				}
			}
			
			if (min > bacon) {
				min = bacon;
				who = i;
			}
		}
		System.out.println(who);
	}
}