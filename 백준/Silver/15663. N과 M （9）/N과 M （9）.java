import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] list;
	static boolean[] visit;
	static int[] arr;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		list = new int[N+1];
		visit = new boolean[N+1];
		arr = new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i+1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		dfs(1, 0);
	}
	public static void dfs(int num, int depth) {
		if (depth == M) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		int check = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i] && list[i] != check) {
				visit[i] = true;
				arr[depth] = list[i];
				check = arr[depth];
				dfs(i, depth + 1);
				visit[i] = false;
			}
		}
	}
}