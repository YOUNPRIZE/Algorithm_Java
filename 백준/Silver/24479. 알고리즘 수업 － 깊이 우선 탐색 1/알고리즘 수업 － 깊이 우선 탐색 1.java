import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[] visited;
	static int cnt = 1;
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
		} // [[0], [2,4], ...]
		
		// 오름차순 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}
		dfs(R);
		
		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}
	}
	public static void dfs(int R) {
		//인자값에 따라서 방문 노드 배열에 초기화
		visited[R] = cnt++;
		for (int i = 0; i < list.get(R).size(); i++) {
			// [[0], [2,4], ...]
			// 이런 식의 배열일 때 2 노드 먼저 방문해서 2 제일 깊은 곳 까지 탐색 후에
			// 4 노드 방문
			// 이러한 로직으로 깊이 우선 탐색.
			if (visited[list.get(R).get(i)] == 0) dfs(list.get(R).get(i));
		}
	}
}
