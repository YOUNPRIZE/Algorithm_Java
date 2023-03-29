import java.util.Scanner;

// 무방향 그래프 및 DFS 풀이
public class Main {
	static int N, M, cnt;
	static int[][] graph;
	static boolean[] visit;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		
			//sb.append("#").append(tc).append(" ");
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N+1][N+1];
        visit = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            // 무방향 그래프
            // 처음에 방향그래프로만 초기화해서 자꾸 틀렸다고 나왔습니당..
            graph[A][B] = 1;
            graph[B][A] = 1;
        }
        cnt = 0;
        for (int i = 1; i <= N; i++) {
            boolean flag = false;
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 1) flag = true;
                if(!visit[j] && graph[i][j] == 1) {
                    dfs(j);
                    cnt++;
                }
            }
            if (!flag&&!visit[i]) cnt++;
        }
        //System.out.println(sb.toString());
		//	sb.append(cnt).append("\n");
		
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