import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int[] map;
	static int[] visit;
	static int S;
	static Queue<Integer> q;
	static int[] dx = {-1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		map = new int[N+1];
		visit = new int[N+1];
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(arr[i-1]);
		}
		S = Integer.parseInt(br.readLine());
		bfs(S);
		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			if (visit[i] == 1) cnt++;
		}
		System.out.println(cnt);
	}
	public static void bfs(int S) {
		q = new LinkedList<>();
		q.add(S);
		visit[S] = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < 2; i++) {
				int nx = cur + map[cur] * dx[i];
				if (nx <= 0 || nx >= N+1) continue;
				if (visit[nx] == 0) {
					visit[nx] = 1;
					q.add(nx);
				}
			}
		}
	}
}