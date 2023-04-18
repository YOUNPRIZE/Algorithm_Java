import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return cost - o.cost;
		}
	}
	static int N, E, u, v;
	static List<Node>[] list;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	static boolean[] visit;
	static PriorityQueue<Node> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		list = new List[N+1];
		for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
//		int 
		
//		System.out.println(INF + 123134234);
		int first = 0;
		int firstRoute1 = dijkstra(1, u);
		int firstRoute2 = dijkstra(u, v);
		int firstRoute3 = dijkstra(v, N);
		if (firstRoute1 == INF || firstRoute2 == INF || firstRoute3 == INF) first = INF;
		else first = firstRoute1 + firstRoute2 + firstRoute3;
		
		int second = 0;
		int secondRoute1 = dijkstra(1, v);
		int secondRoute2 = dijkstra(v, u);
		int secondRoute3 = dijkstra(u, N);
		if (secondRoute1 == INF || secondRoute2 == INF || secondRoute3 == INF) second = INF;
		else second = secondRoute1 + secondRoute2 + secondRoute3;
		
		if (first == INF || second == INF) System.out.println(-1);
		else System.out.println(Math.min(first, second));
	}
	
	public static int dijkstra(int start, int end) {
		visit = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.to;
			
			if (visit[cur]) continue;
			visit[cur] = true;
			
			for (Node node : list[cur]) {
				if (dist[node.to] > dist[cur] + node.cost) {
					dist[node.to] = dist[cur] + node.cost;
					q.add(new Node(node.to, dist[node.to]));
				}
			}
		}
		return dist[end];
	}
}