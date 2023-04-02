import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent, list;
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) parent[i] = i;
		M = Integer.parseInt(br.readLine());
		list = new int[M];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (i < j && num == 1) union(i, j);
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		boolean flag = true;
		for (int i = 1; i < M; i++) {
			if (findset(list[i]) != findset(list[i-1])) {
				flag = false;
				break;
			}
		}
		if (flag) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static int findset(int x) {
		if (x == parent[x]) return x;
		return findset(parent[x]);
	}
	
	public static void union(int x, int y) {
		parent[findset(y)] = findset(x);
	}
}