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
			return cost - o.cost;
		}
		
	}
	static int N,M,p,q;
	static int[] parent;
	static ArrayList<Node> nodeList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			make();
			nodeList = new ArrayList<>();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				nodeList.add(new Node(from, to, cost));
			}
			
			Collections.sort(nodeList);
			
			int cnt = 0;
			boolean flag = false;
			
			for (Node node : nodeList) {
				if (find(node.from) != find(node.to)) {
					union(node.from, node.to);
					if ((node.from == p && node.to == q) || (node.from == q && node.to == p)) flag = true;
					cnt++;
				}
				if (cnt == N-1) break;
			}
			if (flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	public static void make() {
		for (int i = 1; i <= N; i++) parent[i] = i;
	}
	
	public static int find(int x) {
		if (parent[x] == x) return parent[x];
		else return find(parent[x]);
	}
	
	public static void union(int x, int y) {
		parent[find(y)] = find(x);
	}
}