import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Comb {
		int idx;
		int qty;
		public Comb(int idx, int qty) {
			this.idx = idx;
			this.qty = qty;
		}
	}
	static int N,M, result;
	static int[] inDegree, need;
	static boolean[] visit;
	static List<Comb>[] list;
	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		inDegree = new int[N+1];
		need = new int[N+1];
		visit = new boolean[N+1];
		Arrays.fill(visit, true);
		list = new List[N+1];
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		M = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			// X 부품을 만드는데
			int X = Integer.parseInt(st.nextToken());
			// 중간 or 기본 부품인 Y가
			int Y = Integer.parseInt(st.nextToken());
			// K개 필요하다
			int K = Integer.parseInt(st.nextToken());
			
			inDegree[Y]++;
			
			list[X].add(new Comb(Y, K));
			visit[X] = false;
		}
		q.add(N);
		need[N] = 1;
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			int currentQty = need[curr];
//			System.out.println(curr);
			
			for (int i = 0; i < list[curr].size(); i++) {
				int next = list[curr].get(i).idx;
				int newQty = list[curr].get(i).qty;
				
				inDegree[next]--;
				need[next] += currentQty * newQty;
				
				if (inDegree[next] == 0) q.add(next);
			}
		}
		for(int i=1;i<=N;i++){
	        if(visit[i]==true){
	            System.out.println(i+" "+need[i]);
	        }
	    }
	}
}