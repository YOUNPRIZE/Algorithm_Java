import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int M,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		parent = new int[N];
		for (int i = 0; i < N; i++) parent[i] = i;
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (findset(A) == findset(B)) {
				System.out.println(i+1);
				return;
			}
			union(A, B);
		}
		System.out.println(0);
	}
	
	public static int findset(int x) {
		if (parent[x] == x) return x;
		else return findset(parent[x]);
	}
	
	public static void union(int x, int y) {
		parent[findset(y)] = findset(x);
	}
}