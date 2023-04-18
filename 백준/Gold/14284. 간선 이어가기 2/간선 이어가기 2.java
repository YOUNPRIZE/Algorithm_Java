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
	static int N,M, start, end;
	static List<Node>[] list;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	static boolean[] visit;
	static PriorityQueue<Node> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		dist = new int[N+1];
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
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.println(dist[end]);
	}
	
	public static void dijkstra(int start) {
		visit = new boolean[N+1];
		pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0; 
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int cur = node.to;
			
			if (visit[cur]) continue;
			visit[cur] = true;
			
			for (Node n : list[cur]) {
				if (dist[n.to] > dist[cur] + n.weight) {
					dist[n.to] = dist[cur] + n.weight;
					pq.add(new Node(n.to, dist[n.to]));
				}
			}
		}
	}
}