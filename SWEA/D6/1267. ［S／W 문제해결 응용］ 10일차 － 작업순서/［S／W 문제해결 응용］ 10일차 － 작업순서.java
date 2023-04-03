import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int V,E;
	static int[] inDegree;
	static List<Integer>[] graph;
	static LinkedList<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");			
			V = sc.nextInt();
			E = sc.nextInt();
			graph = new List[V+1];
			inDegree = new int[V+1];
			for (int i = 0; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
//			sc.nextLine();
//			String[] str = sc.next().split(" ");
//			sc.nextLine();
//			System.out.println(str[16]);
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				inDegree[to]++;
				graph[from].add(to);
				//graph[to].add(from);
			}
//			System.out.println(Arrays.toString(graph));
//			System.out.println(Arrays.toString(inDegree));
			
			q = new LinkedList<>();
			
			for (int j = 1; j <= V; j++) {
				if (inDegree[j] == 0) {
					q.add(j);
				} 
			}
			
			while(!q.isEmpty()) {
				int node = q.poll();
//				System.out.println(node);
				sb.append(node).append(" ");
				for (int i = 0; i < graph[node].size(); i++) {
					inDegree[graph[node].get(i)] -= 1;
					if (inDegree[graph[node].get(i)] == 0) q.add(graph[node].get(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}