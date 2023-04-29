import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parent;
	// 오르막 마니
	static class NodeAsc implements Comparable<NodeAsc>{
		int from;
		int to;
		int slope;
		
		public NodeAsc(int from, int to, int slope) {
			this.from = from;
			this.to = to;
			this.slope = slope;
		}

		@Override
		public int compareTo(NodeAsc o) {
			// TODO Auto-generated method stub
			return slope - o.slope;
		}
	}
	// 내리막 마니
	static class NodeDesc implements Comparable<NodeDesc> {
		int from;
		int to;
		int slope;
		
		public NodeDesc(int from, int to, int slope) {
			this.from = from;
			this.to = to;
			this.slope = slope;
		}
		@Override
		public int compareTo(NodeDesc o) {
			// TODO Auto-generated method stub
			return o.slope - slope;
		}
		
	}
	static PriorityQueue<NodeAsc> q1 = new PriorityQueue<>();
	static PriorityQueue<NodeDesc> q2 = new PriorityQueue<>();
	static int tired1, tired2, cnt1, cnt2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) parent[i] = i;
		
		tired1 = tired2 = cnt1 = cnt2 = 0;
		
		for (int i = 0 ; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int slope = Integer.parseInt(st.nextToken());
			if (from == 0) {
				if (slope == 0) {
					tired1++;
					tired2++;
				}
//				tired1 += slope;
//				tired2 += slope;
			} else {
				q1.add(new NodeAsc(from, to , slope));
				q2.add(new NodeDesc(from, to , slope));
			}
		}
//		System.out.println(tired1);
//		System.out.println(tired2);
//		int tired = 0;
//		int cnt = 0;
		while (!q1.isEmpty()) {
			if (cnt1 >= N - 1) break;
			
			NodeAsc node = q1.poll();
			
			if (find(node.from) != find(node.to)) {
				union(node.from, node.to);
				if (node.slope == 0) tired1++;
//				System.out.println(tired1);
				cnt1++;	
			}
		}
//		System.out.println(tired1);
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) parent[i] = i;
		
//		int tired2 = 0;
//		int cnt2 = 0;
		while(!q2.isEmpty()) {
			if (cnt2 >= N - 1) break;
			
			NodeDesc node = q2.poll();
			
			if (find(node.from) != find(node.to)) {
				union(node.from, node.to);
				if (node.slope == 0) tired2++;
				cnt2++;
			}
		}
//		System.out.println(tired2);
		System.out.println(Math.abs((tired2 * tired2) - (tired1 * tired1)));
	}
	
	public static int find(int x) {
		if (parent[x] == x) return x;
		else return find(parent[x]);
	}
	
	public static void union(int x, int y) {
		parent[find(y)] = find(x);
	}
}