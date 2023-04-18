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
		int len;
		
		public Node(int to, int len) {
			this.to = to;
			this.len = len;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return len - o.len;
		}
	}
	static int N, M, R;
	static int INF = Integer.MAX_VALUE;
	static int[] items, dist;
	static List<Node>[] list;
	static PriorityQueue<Node> q;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 지역의 개수
		N = Integer.parseInt(st.nextToken());
		// 예은이의 수색범위
		M = Integer.parseInt(st.nextToken());
		// 길의 개수
		R = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		items = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) items[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, len));
			list[to].add(new Node(from, len));
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			dijkstra(i);
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (dist[j] <= M) cnt += items[j];
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	
	public static void dijkstra(int start) {
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		visit = new boolean[N+1];
		dist[start] = 0;
		q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.to;
			
			for (Node node : list[cur]) {
				if (dist[node.to] > dist[cur] + node.len) {
					dist[node.to] = dist[cur] + node.len;
					q.add(new Node(node.to, dist[node.to]));
				}
			}
		}
	}
}