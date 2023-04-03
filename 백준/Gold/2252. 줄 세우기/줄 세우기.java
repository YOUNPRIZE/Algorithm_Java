import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] inDegree;
	static List<Integer>[] list;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inDegree = new int[N+1];
		list = new List[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			inDegree[to]++;
		}
		
		q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			for (int i = 0; i < list[node].size(); i++) {
				inDegree[list[node].get(i)]--;
				if (inDegree[list[node].get(i)] == 0) q.add(list[node].get(i));
			}
		}
	}
}