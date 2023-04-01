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
		int V, W;
		public Node(int V, int W) {
			this.V = V;
			this.W = W;
		}
		@Override
		public int compareTo(Node o) {
			return W - o.W;
		}
	}
	static int N,M;
	static List<Node>[] list;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) list[i] = new ArrayList<>();
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(to, weight));
			list[to].add(new Node(start, weight));
		}
//		System.out.println(Arrays.toString(list));
		dijkstra(1);
//		System.out.println(Arrays.toString(dist[N]));
		System.out.println(dist[N]);
	}
	
	public static void dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		dist[start] = 0; // 시작 노드까지의 거리는 0
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int cur = curr.V;
			
			if (visited[cur]) continue;
			visited[cur] = true;
			
			for (Node node : list[cur]) {
				if (dist[node.V] > dist[cur] + node.W) {
					dist[node.V] = dist[cur] + node.W;
					q.add(new Node(node.V, dist[node.V]));
				}
			}
		}
		
//		for (int i = 1; i <= N - 1; i++) {
//			int min = Integer.MAX_VALUE;
//			int idx = -1;
//			
//			for (int j = 1; j <= N; j++) {
//				if(!visited[j] && min > dist[j]) {
//					min = dist[j];
//					idx = j;
//				}
//			}
//			
//			if (idx == -1) break;
//			
//			visited[idx] = true;
//			
//			for (int j = 0; j < list[idx].size(); j++) {
//				Node curr = list[idx].get(j);
//				
//				if (!visited[curr.V] && dist[curr.V] > dist[idx] + curr.W)
//					dist[curr.V] = dist[idx] + curr.W;
//			}
//		}
	}
}