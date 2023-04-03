import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] inDegree;
	static List<Integer>[] list;
	static PriorityQueue<Node> q;
	static class Node implements Comparable<Node> {
		int node;
		
		public Node(int node) {
			this.node = node;
		}

		@Override
		public int compareTo(Node o) {
			return node - o.node;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inDegree = new int[N+1];
		list = new List[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			inDegree[to]++;
		}
		
		q = new PriorityQueue<>();
		
		// 진입 차수가 0인 모든 노드를 Queue에 삽입
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) q.add(new Node(i));
		}
		
		// Queue가 공백상태가 될 때까지 반복
		while(!q.isEmpty()) {
			Node n = q.poll();
			System.out.print(n.node + " ");
			for (int i = 0; i < list[n.node].size(); i++) {
				// Queue에서 꺼낸 노드에서 나가는 간선을 그래프에서 제거
				inDegree[list[n.node].get(i)]--;
				// 진입 차수가 0이 된 노드를 Queue에 삽입한다.
				if (inDegree[list[n.node].get(i)] == 0) q.add(new Node(list[n.node].get(i)));
			}
		}
	}
}