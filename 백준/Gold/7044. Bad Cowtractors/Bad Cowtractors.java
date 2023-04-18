import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.cost - cost;
		}
	}
	static int N, M;
	static int[] parent;
	static ArrayList<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) parent[i] = i;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Node(from, to, cost));
			// acycle?
		}
		
		Collections.sort(list);
		
		int cnt = 0;
		int cost = 0;
		
		for (Node node : list) {
			if (find(node.from) != find(node.to)) {
				union(node.from, node.to);
				cnt++;
				cost += node.cost;
				
				if (cnt == N-1) break;
			}
		}
		
		if (cnt != N-1) System.out.println(-1);
		else System.out.println(cost);
	}
	
	public static int find(int x) {
		if (parent[x] == x) return x;
		else return find(parent[x]);
	}
	
	public static void union(int x, int y) {
		parent[find(y)] = find(x);
	}
}