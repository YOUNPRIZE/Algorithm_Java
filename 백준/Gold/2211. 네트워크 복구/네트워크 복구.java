import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}
	static int N,M;
	static List<Node>[] list;
	static boolean[] visit;
	static PriorityQueue<Node> q;
	static int[] dist, route;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		dist = new int[N+1];
		route = new int[N+1];
		Arrays.fill(dist, INF);
		for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		dijkstra(1);
//		for (int i = 1; i <= N; i++) {
////			System.out.println(dist[i]);
//			System.out.println(route[i]);
//		}
		
		System.out.println(N-1);
		for (int i = 2; i <= N; i++) {
			System.out.print(i + " ");
			System.out.println(route[i]);
		}
	}
	
	public static void dijkstra(int start) {
		q = new PriorityQueue<>();
		visit = new boolean[N+1];
		dist[start] = 0;
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int cur = node.to;
			int curWeight = node.weight;
			
			if (visit[cur]) continue;
			visit[cur] = true;
			
			for (Node n : list[cur]) {
				if (dist[n.to] > dist[cur] + n.weight) {
					route[n.to] = cur;
					dist[n.to] = dist[cur] + n.weight;
					q.add(new Node(n.to, dist[n.to]));
				}
			}
		}
	}
}