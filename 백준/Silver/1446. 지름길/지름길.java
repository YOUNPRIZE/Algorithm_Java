import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, D, distance[], INF = Integer.MAX_VALUE;
	static List<Node> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		distance = new int[10001]; 
		graph = new List[10001]; 
		for(int i=0; i<graph.length; i++) {
			distance[i] = i;
			graph[i] = new ArrayList<>(); 
		}
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			graph[start].add(new Node(end, d));
		}
		dijkstra(0);

		System.out.println(distance[D]);
	}
	private static void dijkstra(int start) {
		if(start > D) {
			return;
		}
		if(distance[start+1] > distance[start] + 1) {
			distance[start+1] = distance[start] + 1;
		}
		
		for(int i=0; i<graph[start].size(); i++) {
			if(distance[start] + graph[start].get(i).value < distance[graph[start].get(i).endPoint]) {
				distance[graph[start].get(i).endPoint] = distance[start] + graph[start].get(i).value;
			}
		}
		dijkstra(start+1);
	}
	static class Node {
		int endPoint;
		int value;
		public Node(int endPoint, int value) {
			super();
			this.endPoint = endPoint;
			this.value = value;
		}
	} 
}