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
	static int V,E,P;
	static int[] dist, route;
	static int INF = Integer.MAX_VALUE;
	static boolean[] visit;
	static PriorityQueue<Node> q;
	static List<Node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		

		list = new List[V+1];
		for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		
		dijkstra(P);
		int gunwoo = dist[1] + dist[V];
		dijkstra(1);
		int route = dist[V];
		if (route == gunwoo) System.out.println("SAVE HIM");
		else System.out.println("GOOD BYE");
	}
	
	public static void dijkstra(int start) {
		// 큐 선언
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		q = new PriorityQueue<>();
		dist[start] = 0;
		visit = new boolean[V+1];
		// 큐에 넣기
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int cur = node.to;
			
			if(visit[cur]) continue;
			visit[cur] = true;
			
			for (Node n : list[cur]) {
				int next = n.to;
				if (dist[next] > dist[cur] + n.cost) {
//					System.out.println(next);
//					route[next] = cur;
					dist[next] = dist[cur] + n.cost;
					q.add(new Node(next, dist[next]));
				}
			}
		}
	}
}