import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int V,E;
	// 진입차수 저장 배열
	static int[] inDegree;
	// 인접리스트
	static List<Integer>[] graph;
	static boolean[] visit;
	static Stack<Integer> stack;
	static LinkedList<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");			
			V = sc.nextInt();
			E = sc.nextInt();
			stack = new Stack<>();
			graph = new List[V+1];
			visit = new boolean[V+1];
			inDegree = new int[V+1];
			for (int i = 0; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				inDegree[to]++;
				graph[from].add(to);
			}
			
			for (int j = 1; j <= V; j++) {
				if (inDegree[j] == 0) {
					Topological_sort(j);
				} 
			}
			System.out.println();
			while(stack.size() != 0) {
				sb.append(stack.pop()).append(" ");
			}
			
//			q = new LinkedList<>();
//			
//			// 진입 차수가 0인 모든 노드를 Queue에 삽입
//			for (int j = 1; j <= V; j++) {
//				if (inDegree[j] == 0) {
//					q.add(j);
//				} 
//			}
//			
//			// Queue가 공백상태가 될 때까지 반복
//			while(!q.isEmpty()) {
//				int node = q.poll();
//				// Queue에서 꺼내지는 순서가 위상 정렬을 수행한 결과
//				sb.append(node).append(" ");
//				for (int i = 0; i < graph[node].size(); i++) {
//					// Queue에서 꺼낸 노드에서 나가는 간선을 그래프에서 제거
//					inDegree[graph[node].get(i)] -= 1;
//					// 진입 차수가 0이 된 노드를 Queue에 삽입한다.
//					if (inDegree[graph[node].get(i)] == 0) q.add(graph[node].get(i));
//				}
//			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void Topological_sort(int v) {
		visit[v] = true;
//		System.out.println(v);
		for (int i = 0; i < graph[v].size(); i++) {
			if (!visit[graph[v].get(i)]) Topological_sort(graph[v].get(i));
		}
		
		stack.push(v);
	}
}