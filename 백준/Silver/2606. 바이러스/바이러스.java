import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visited = new int[N+1];
		
		for(int i = 0; i<=N; i++)
            list.add(new ArrayList<>());
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		bfs(1);
	}
	
	public static void bfs(int R) {
		Queue<Integer> q = new LinkedList<>();
		
		int cnt = 1;
		visited[R] = cnt++;
		q.add(R);
		while(!q.isEmpty()) {
			int element = q.poll();
			for (int i = 0; i < list.get(element).size(); i++) {
				int next = list.get(element).get(i);
				
				if (visited[next] != 0)
					continue;
				q.add(next);
				visited[next] = cnt++;
			}
		}
		int max = 0;
		for (int i = 0; i < visited.length; i++) {
			max = (max < visited[i]) ? visited[i] : max;
		}
		System.out.println(max-1);
	}
}
