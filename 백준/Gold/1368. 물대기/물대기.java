import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int node1;
		int node2;
		long cost;

		public Edge(int node1, int node2, long cost) {
			this.node1 = node1;
			this.node2 = node2;
			this.cost = cost;
		}

		public int compareTo(Edge other) {
			if (this.cost > other.cost)
				return 1;
			else if (this.cost < other.cost)
				return -1;
			else
				return 0;
		}
	}
	static int[] parent;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			int cost = Integer.parseInt(br.readLine());
			edges.add(new Edge(i, N+1, cost));
		}
		for (int i = 1; i <= N; i++) {
//			st = new StringTokenizer(br.readLine());
			String[] str = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
//				int cst = Integer.parseInt(st.nextToken());
				int cst = Integer.parseInt(str[j-1]);
				if (i >= j) continue;
				edges.add(new Edge(i, j, cst));
			}
		}
//		System.out.println(124);
		parent = new int[N+2];
		for (int i = 1; i <= N + 1; i++) {
			parent[i] = i;
		}
		long cost = 0;
		int cnt = 0;
		while(!edges.isEmpty()) {
			if (cnt >= N) break;
			
			Edge e = edges.poll();
			int n1 = e.node1;
			int n2 = e.node2;
			
			if (find(n1) != find(n2)) {
				union(n1, n2);
				cost += e.cost;
				cnt++;
			}
		}
		System.out.println(cost);
	}
	
	public static int find(int v) {
		if (v == parent[v]) return v;
		else return find(parent[v]);
	}
	public static void union(int x, int y) {
		parent[find(y)] = find(x);
	}
}