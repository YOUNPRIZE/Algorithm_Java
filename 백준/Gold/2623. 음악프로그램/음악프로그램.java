import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[] inDegree;
	static List<Integer>[] list;
	static Queue<Integer> q, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		inDegree = new int[N+1];
		q = new LinkedList<>();
		result = new LinkedList<>();
		list = new List[N+1];
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int len = Integer.parseInt(str[0]);
			
			for (int j = 2; j < str.length; j++) {
				list[Integer.parseInt(str[j-1])].add(Integer.parseInt(str[j]));
				inDegree[Integer.parseInt(str[j])]++;
			}
		}
		
		for (int j = 1; j <= N; j++) {
			if (inDegree[j] == 0) {
				q.add(j);
			} 
		}
		
		// Queue가 공백상태가 될 때까지 반복
		while(!q.isEmpty()) {
			int node = q.poll();
			// Queue에서 꺼내지는 순서가 위상 정렬을 수행한 결과
			result.add(node);
			for (int i = 0; i < list[node].size(); i++) {
				// Queue에서 꺼낸 노드에서 나가는 간선을 그래프에서 제거
				inDegree[list[node].get(i)] -= 1;
				// 진입 차수가 0이 된 노드를 Queue에 삽입한다.
				if (inDegree[list[node].get(i)] == 0) q.add(list[node].get(i));
			}
		}
		if (result.size() != N) System.out.println(0);
		else {
			for (int i : result) sb.append(i).append("\n");
			System.out.println(sb.toString());
		}
	}
	
//	public static void Topological_sort(int v) {
//		visit[v] = true;
//		for (int i = 0; i < list[v].size(); i++) {
//			inDegree[list[v].get(i)]--;
//			if (!visit[list[v].get(i)]) {
//				
//				Topological_sort(list[v].get(i));
//			}
//		}
//		cnt++;
//		stack.push(v);
//	}
}