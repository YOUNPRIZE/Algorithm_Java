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
	static int N;
	static int[] inDegree, costs, result;
	static List<Integer>[] list;
	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		inDegree = new int[N+1];
		costs = new int[N+1];
		result = new int[N+1];
		list = new List[N+1];
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int preOrder = Integer.parseInt(st.nextToken());
			costs[i] = cost;
			if (preOrder > 0) {
				for (int j = 0; j < preOrder; j++) {
					inDegree[i]++;
					int from = Integer.parseInt(st.nextToken());
					list[from].add(i);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) q.add(i);
		}
		while(!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 0; i < list[curr].size(); i++) {
				inDegree[list[curr].get(i)]--;
				result[list[curr].get(i)] = Math.max(result[list[curr].get(i)], result[curr] + costs[curr]);
				if (inDegree[list[curr].get(i)] == 0) {
					q.add(list[curr].get(i));
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			result[i] += costs[i];
			max = Math.max(result[i], max);
		}
//		System.out.println(Arrays.toString(result));
//		System.out.println(Collections.max(result));
//		System.out.println(result[N]);
		System.out.println(max);
	}
}