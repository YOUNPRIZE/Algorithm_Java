import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		long cost;
		public Edge(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return (int) (cost - o.cost);
		}
	}
	static int[] parent;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) parent[i] = i;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(from, to, cost));
			edgeList.add(new Edge(to, from, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Collections.sort(edgeList, Collections.reverseOrder());
		
		long ans = Integer.MAX_VALUE;
		
		for(Edge edge : edgeList) {
//			if (find(edge.from) == find(edge.to)) {
//				union(edge.from, edge.to);
//				max = Math.max(max, edge.cost);
//				break;
//			}
			union(edge.from, edge.to);
			ans = Math.min(ans, edge.cost);
			if (find(start) == find(end)) break;
		}
		System.out.println(ans);
	}
	
	public static int find(int x) {
		if (x == parent[x]) return x;
		else return find(parent[x]);
	}
	
	public static void union(int x, int y) {
		parent[find(y)] = find(x);
	}
}