import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long price, total;
	static int[] parents;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(from, to, weight));
			total += weight;
		}
		Collections.sort(edgeList);
		make();
		
		int cnt = 0;
		price = 0;
		for (Edge e : edgeList) {
			if (union(e.from, e.to)) {
				price += e.cost;
				cnt++;
				if (cnt == N-1) break;
			}
		}
//		System.out.println(cnt);
		if (cnt < N - 1) System.out.println(-1);
		else
		System.out.println(total-price);
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
		for (int i = 0; i <= N; i++) {
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