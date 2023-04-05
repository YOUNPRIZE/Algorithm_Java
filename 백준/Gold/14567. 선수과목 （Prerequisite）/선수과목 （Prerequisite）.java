import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] inDegree, semester;
	static List<Integer>[] list;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		inDegree = new int[N+1];
		semester = new int[N+1];
		list = new List[N+1];
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
		}
//		System.out.println(Arrays.toString(list));
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				semester[i] = 1;
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
//			System.out.println(cur);
//			System.out.println(Arrays.toString(semester));
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				semester[next] = Math.max(semester[next], semester[cur] + 1);
				inDegree[next]--;
				if (inDegree[next] == 0) q.add(next);
			}
		}
		
//		System.out.println(Arrays.toString(semester));
		for (int i = 1; i <= N; i++) {
			System.out.print(semester[i] + " ");
		}
	}
}