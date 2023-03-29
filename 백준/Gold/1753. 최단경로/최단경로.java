import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
	static int V, E, K;
	static List<Node>[] list;
    static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, w));
		}
		
		StringBuilder sb = new StringBuilder();
		
		dijkstra(K);
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		System.out.println(sb.toString());
	} 
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.end;
			
			if(check[cur] == true) continue;
			check[cur] = true;
			
			for (Node node : list[cur]) {
				if (dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					q.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}