
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 수 N
		N = Integer.parseInt(st.nextToken());
		// 간선의 수 M
		M = Integer.parseInt(st.nextToken());
		// 시작 정점 R
		R = Integer.parseInt(st.nextToken());
		// 방문한 노드 체크할 배열 선언
		visited = new int[N+1];
		// List 안에 List 추가
		for(int i = 0; i<=N; i++)
            list.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		} // [[0], [4,2], ...]
		
		// 내림차순 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		
		bfs(R);
		
		// 출력
		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}
	}
	
	public static void bfs(int R) {
		// 큐 선언
		Queue<Integer> q = new LinkedList<>();
		// 방문 순서 변수 선언 및 초기화
		int cnt = 1;
		// 시작 정점을 방문 체크 배열에 할당? 초기화? ㅇㅇ
		visited[R] = cnt++;
		q.add(R);
		while(!q.isEmpty()) {
			int element = q.poll();
			for (int i = 0; i < list.get(element).size(); i++) {
				// 오름차순 정렬된 정점의 간선
				int next = list.get(element).get(i);
				
				// 방문했으면 pass, 방문하지 않았다면 그대로 
				if (visited[next] != 0)
					continue;
				
				q.add(next);
				visited[next] = cnt++;
			}
		}
	}
}
