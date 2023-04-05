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
	static int[] dist, distFrom;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new List[N+1];
		
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int[] temp = dijkstra(i);
//			System.out.println(Arrays.toString(temp));
			for (int j = 1; j <= N; j++) {
				if (i == temp[j]) sb.append(j).append(" ");
				else if (temp[j]== 0) sb.append("-").append(" ");
				else sb.append(temp[temp[j]]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int[] dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		distFrom = new int[N+1];
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0; // 시작 노드까지의 거리는 0
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int cur = curr.to;
			
			// 방문했으면 continue
			if (visited[cur]) continue;
			// 방문 처리
			visited[cur] = true;
			
			// 현재 정점에 있는 node들 반복
			for (Node node : list[cur]) {
				// 현재 정점에서 갈 곳의 정점의 가중치가 현재 정점 + 가중치 값보다 큰 경우
				if (dist[node.to] > dist[cur] + node.weight) {
					// 갱신
					dist[node.to] = dist[cur] + node.weight;
					
					if (cur == start) distFrom[node.to] = node.to;
					else distFrom[node.to] = distFrom[cur];
					// 큐에 삽입
					q.add(new Node(node.to, dist[node.to]));
				}
			}
		}
		return distFrom;
	}
}