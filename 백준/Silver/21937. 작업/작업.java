import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int cnt;
		public Node(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int N,M;
	static int[] inDegree, result;
	static boolean[] visit;
	static Queue<Node> q;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		inDegree = new int[N+1];
//		result = new int[N+1];
		list = new List[N+1];
		visit = new boolean[N+1];
		for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[to].add(from);
//			inDegree[to]++;
		}
		
		int work = Integer.parseInt(br.readLine());
		System.out.println(dfs(work));
//		q = new LinkedList<>();
//		for (int i = 1; i <= N; i++) if (inDegree[i] == 0) q.add(new Node(i, 0));
		
//		while(!q.isEmpty()) {
//			Node node = q.poll();
//			int cur = node.x;
//			System.out.println(cur);
//			System.out.println(node.cnt);
//			System.out.println();
//			for(int i = 0; i < list[cur].size(); i++) {
//				int next = list[cur].get(i);
//				inDegree[next]--;
//				result[next] += result[cur] + 1;
//				if (inDegree[next] == 0) q.add(new Node(next, node.cnt+1));
//			}
//		}
		
//		System.out.println(result[work]);
	}
	
	public static int dfs(int x) {
		int cnt = 0;
		
		for (int i : list[x]) {
			if(visit[i]) continue;
			visit[i] = true;
			cnt += dfs(i) + 1;
		}
		
		return cnt;
	}
}