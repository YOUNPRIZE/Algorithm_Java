import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//무방향 그래프 및 DFS 풀이
public class Main {
	static int N, M, cnt;
	static int[][] graph;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// sb.append("#").append(tc).append(" ");
		
//		N = sc.nextInt();
//		M = sc.nextInt();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// 무방향 그래프
			// 처음에 방향그래프로만 초기화해서 자꾸 틀렸다고 나왔습니당..
			graph[A][B] = 1;
			graph[B][A] = 1;
		}
		cnt = 0;
		for (int i = 1; i <= N; i++) {
			boolean flag = false;
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 1)
					flag = true;
				if (!visit[j] && graph[i][j] == 1) {
					dfs(j);
					cnt++;
				}
			}
			if (!flag && !visit[i])
				cnt++;
		}
		// System.out.println(sb.toString());
		// sb.append(cnt).append("\n");

		System.out.println(cnt);
	}

	public static void dfs(int row) {
		visit[row] = true;
		for (int i = 1; i <= N; i++) {
			if (graph[row][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
}