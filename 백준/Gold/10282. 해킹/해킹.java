import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, D, C;
	static class Node implements Comparable<Node>{
		int to;
		int second;
		public Node(int to, int second) {
			this.to = to;
			this.second = second;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return second - o.second;
		}
	}
	static List<Node>[] list;
    static int[] dist;
	static PriorityQueue<Node> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			// 컴퓨터 개수
			N = Integer.parseInt(st.nextToken());
			list = new ArrayList[N+1];
			dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
			// 의존성 개수
			D = Integer.parseInt(st.nextToken());
			// 해킹당한 컴퓨터 번호
			C = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				list[to].add(new Node(from, w));
			}
			dijkstra(C);
//			System.out.println(Arrays.toString(dist));
			int cnt = 0;
			int ans = Integer.MIN_VALUE;
			for (int i : dist) {
				if (i != Integer.MAX_VALUE) {
					cnt++;
					ans = Math.max(ans, i);
				}
			}
			sb.append(cnt).append(" ").append(ans).append("\n");
//			System.out.print(cnt + " ");
//			System.out.println(ans);
		}
		System.out.println(sb.toString());
	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] check = new boolean[N+1];
		// 우선순위 큐에 시작점 추가
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.to;
			
			// 방문했을 경우 continue
			if(check[cur] == true) continue;
			check[cur] = true;
			
			for (Node node : list[cur]) {
				// cur을 거쳐가는 것이 더 작은 값을 가질 경우
				// dist를 갱신하고 큐에 추가하기
				if (dist[node.to] > dist[cur] + node.second) {
					dist[node.to] = dist[cur] + node.second;
					q.add(new Node(node.to, dist[node.to]));
				}
			}
		}
	}
}