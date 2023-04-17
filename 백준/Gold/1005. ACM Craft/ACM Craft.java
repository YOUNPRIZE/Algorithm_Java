import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K,W;
	static int[] inDegree, time, result;
	static List<Integer>[] list;
	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N+1];
			result = new int[N+1];
			inDegree = new int[N+1];
			list = new List[N+1];
			for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
			
			String[] timeArr = br.readLine().split(" ");
			
			for (int i = 1; i <= timeArr.length; i++) {
				time[i] = Integer.parseInt(timeArr[i-1]);
			}
			result = time.clone();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				inDegree[to]++;
				list[from].add(to);
			}
			
			W = Integer.parseInt(br.readLine());
			
			q = new LinkedList<>();
			
			for (int i = 1; i <= N; i++) {
				if (inDegree[i] == 0) q.add(i);
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for (int i = 0; i < list[cur].size(); i++) {
					int next = list[cur].get(i);
					result[next] = Math.max(result[next], result[cur] + time[next]);
					inDegree[next]--;
					if (inDegree[next] == 0) q.add(next);
				}
			}
			
//			int max = Integer.MIN_VALUE;
//			
//			for (int i = 1; i <= N; i++) {
//				max = Math.max(max, result[i]);
//			}
//			System.out.println(max);
//			System.out.println(result[W]);
			sb.append(result[W]).append("\n");
		}
		System.out.println(sb.toString());
	}
}