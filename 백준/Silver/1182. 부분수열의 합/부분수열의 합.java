import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static int[] list;
	static int[] newList;
	static int cnt;
	static boolean[] isUsed;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NS = br.readLine().split(" ");
		N = Integer.parseInt(NS[0]);
		S = Integer.parseInt(NS[1]);
		list = new int[N];
		newList = new int[N];
		//isUsed = new boolean[N];
		cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		if (S == 0) cnt--;
		System.out.println(cnt);
	}
	public static void dfs(int cur, int total) {
		if (cur == N) {
			if (total == S) cnt++;
			return;
		}
		dfs(cur+1, total);
		dfs(cur+1, total+list[cur]);
	}
}