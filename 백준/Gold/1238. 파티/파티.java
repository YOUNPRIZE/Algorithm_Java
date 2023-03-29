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
	static int V, E, X;
	static List<Node>[] list, list2;
    static int[] dist, distX, distR;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		list2 = new ArrayList[V+1];
		
		
		for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
		for (int i = 1; i <= V; i++) list2[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, w));
			list2[to].add(new Node(from, w));
		}
		
		//StringBuilder sb = new StringBuilder();
		int max = Integer.MIN_VALUE;
		dijkstra(X);
		distX = new int[V+1];
		for (int i = 1; i <= V; i++) if (dist[i] != Integer.MAX_VALUE) distX[i] = dist[i];
		dijkstra2(X);
		distR = new int[V+1];
		for (int i = 1; i <= V; i++) if (dist[i] != Integer.MAX_VALUE) distR[i] = dist[i];
		
		int ans = 0;
        for (int i = 1; i <= V; i++) {
            max = Math.max(max, distX[i] + distR[i]);
        }
		
		System.out.println(max);
	} 
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		q.add(new Node(start, 0));
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
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
	
	public static void dijkstra2(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		q.add(new Node(start, 0));
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.end;
			
			if(check[cur] == true) continue;
			check[cur] = true;
			
			for (Node node : list2[cur]) {
				if (dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					q.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}