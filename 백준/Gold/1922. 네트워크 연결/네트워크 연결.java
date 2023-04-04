import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
static int[] p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		int[][] edges = new int[E][3];
		
		for(int i = 0 ; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (from == to) continue;
			edges[i][0] = from;
			edges[i][1] = to;
			edges[i][2] = cost;
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		p = new int[V+1];
		for(int i = 0 ; i<=V; i++) {
			p[i] = i;
		}
		
		long ans = 0;
		int pick = 0;
		for(int i = 0; i < E; i++) {
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);
			
			if(px!= py) {
				union(px, py);
				ans += edges[i][2];
//				System.out.println(edges[i][2]);
				pick++;
			}
			
			if(pick == (V-1)) break;
		}
		

		System.out.println(ans);
		
	}
	
	//대표를 반환해야 하므로~~
	static int findset(int x) {
		//순수 기술
//		if(x == p[x]) return x;
//		return findset(p[x]);
		//패쓰 컴프레숀~~ 적용 
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
//		p[findset(y)] = findset(x); //rank 이런거 고려 안했고 그냥 y를 무조건 x밑으로
		p[y] = x; //정석은 아니지만 이번문제에서 가능한 부분
		//허나 왜이렇게 써도 되는지는 고민을 해보고 알고 써야되는 부분
	}
}