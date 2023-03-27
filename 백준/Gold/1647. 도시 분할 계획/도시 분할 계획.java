import java.util.*;
import java.io.*;

// Kruskal Algorithm
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int V, E;
		st = new StringTokenizer(br.readLine());
		// 정점의 개수
		V = Integer.parseInt(st.nextToken());
		// 간선의 개수
		E = Integer.parseInt(st.nextToken());

		PriorityQueue<Edge> edges = new PriorityQueue<>();

		int node1, node2;
		long cost;
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			cost = Long.parseLong(st.nextToken());
			//priority queue에 edge를 전부 추가
			edges.add(new Edge(node1, node2, cost));
		}
		
		// Union Find
		DisjointSet ds = new DisjointSet(V);

		cost = 0;
		int cnt = 0;
		Edge e;
		while (!edges.isEmpty()) {
			//edge를 V - 1개 선택하면 알고리즘 종료
			if (cnt >= V - 2)
				break;

			e = edges.poll();
			
			//두 node 사이에 경로가 존재하지 않을 경우에만 현재 선택한 edge를 추가함
			if (ds.find(e.node1) != ds.find(e.node2)) {
				ds.union(e.node1, e.node2);
				cost += e.cost;
				cnt++;
			}
		}

		System.out.println(cost);

		br.close();
	}
}

class Edge implements Comparable<Edge> {
	int node1;
	int node2;
	long cost;

	public Edge(int node1, int node2, long cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}

	public int compareTo(Edge other) {
		if (this.cost > other.cost)
			return 1;
		else if (this.cost < other.cost)
			return -1;
		else
			return 0;
	}
}

// union-find
class DisjointSet {
	int[] parent;

	public DisjointSet(int N) {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;
	}
	
	// 경로가 연결이 안돼있을 때 결합?연결?해주는 메소드
	public void union(int e1, int e2) {
		int parent1 = find(e1);
		int parent2 = find(e2);
		parent[parent1] = parent2;
	}
	
	// 경로 찾는 메소드
	// 연결이 돼있는지?
	public int find(int e){
		if (parent[e] == e)
			return e;
		parent[e] = find(parent[e]);
		return parent[e];
	}
}