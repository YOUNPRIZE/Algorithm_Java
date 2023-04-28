import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static class Node implements Comparable<Node> {
		int to;
		long cost;
		public Node(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return (int) (cost - o.cost);
		}
	}
	static PriorityQueue<Node> q;
	static boolean[] visit;
	static int[] sight; 
	static long[] result;
	static List<Node>[] list;
	static Long INF = Long.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sight = new int[N];
		list = new List[N];
		for (int i = 0; i < N; i++) list[i] = new ArrayList<>();
		result = new long[N];
		Arrays.fill(result, INF);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sight[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			//if (sight[from] == 1 || sight[to] == 1) continue;
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		
		dijkstra(0);
		
		if (result[N-1] == INF) System.out.println(-1);
		else System.out.println(result[N-1]);
		
//		System.out.println(result[N-1]);
//		System.out.println(Arrays.toString(result));
	}
	
	public static void dijkstra(int start) {
		q = new PriorityQueue<>();
		visit = new boolean[N];
		//visit[start] = true;
		q.add(new Node(start, 0));
		result[start] = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int cur = node.to;
			
			if (visit[cur]) continue;
			visit[cur] = true;
			
			for (Node next : list[cur]) {
				if (sight[next.to] == 1 && next.to != N - 1) continue;
				if (result[next.to] > result[cur] + next.cost) {
					result[next.to] = result[cur] + next.cost;
					q.add(new Node(next.to, result[next.to]));
				}
			}
		}
	}
}