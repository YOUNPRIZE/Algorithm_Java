import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// Kruskal Algorithm
public class Main {
	static int N;
	static long ans;
	static int[] parents;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(i,j,cost));
			}
		}
		
		Collections.sort(edgeList);
		
		make();
		
		int cnt = 0;
		
		for (Edge e : edgeList) {
			if (union(e.from, e.to)) {
				ans += e.cost;
				cnt++;
				if (cnt == N-1) break;
			}
		}
		System.out.println(ans);
	}
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	private static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	private static int findSet(int v) {
		if (parents[v] == v) return v;
		return parents[v] = findSet(parents[v]);
	}
	
	private static boolean union(int from, int to) {
		int fromRoot = findSet(from);
		int toRoot = findSet(to);
		
		if (fromRoot == toRoot) return false;
		parents[toRoot] = fromRoot;
		return true;
		
	}
}