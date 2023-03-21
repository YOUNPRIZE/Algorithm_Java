import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,L,cnt;
	static int[][] graph;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] NL = br.readLine().split(" ");
		N = Integer.parseInt(NL[0]);
		L = Integer.parseInt(NL[1]);
		graph = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			if (check(i, 0, true)) cnt++; // 행 체크
				
			if (check(0, i, false)) cnt++; // 열 체크
		}
		System.out.println(cnt);
	}
	
	// true : 행
	// false : 열
	public static boolean check(int x, int y, boolean rowcol) {
		int[] height = new int[N];
		boolean[] visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			if (rowcol) height[i] = graph[x][i];
			else height[i] = graph[i][y];
		}
		
		for (int i = 0; i < N - 1; i++) {
			// 높이가 같을 때
			if (height[i] == height[i+1]) continue;
			
			// 하강일 때
			else if(height[i] - height[i+1] == 1) {
				for (int j = i + 1; j <= i + L; j++) {
					// 범위 초과 or 칸의 높이 다름 or 이미 경사로 있으면 continue
					if (j >= N || height[i+1] != height[j] || visited[j]) return false;
					visited[j] = true;
				}
			}
			
			// 상승일 때
			else if (height[i]-height[i+1] == -1) {
				for (int j = i; j > i - L; j--) {
					// 범위 초과 or 칸의 높이 다름 or 경사로가 있으면 continue
					if (j < 0 || height[i] != height[j] || visited[j]) return false;
					visited[j] = true;
				}
			}
			// 높이가 2칸 이상 차이날 때
			else return false;
		}
		return true;
	}
}