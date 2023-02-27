import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static String[][] arr = new String[5][5];
	static int[][] visit = new int[5][5];
	static List<String> list = new ArrayList<>();
	static int cnt;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//set = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				
				arr[i][j] = st.nextToken();
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, arr[i][j]);
			}
		}
		System.out.println(list.size());
	}
	
//	static public void dfs(int[] loc) {
//		if (cnt == 5) {
//			if(!list.contains(tmp)) {
//				list.add(tmp);
//			}
//			return;
//		}
//		for (int i = 0; i < 4; i++) {
//			int nx = loc[0] + dx[i];
//			int ny = loc[1] + dy[i];
//			
//			if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
//			else {
//				sb.append(arr[nx][ny]);
//				cnt++;
//				dfs(new int[] {nx, ny});
//				
//			}
//		}
//	}
	
	public static void dfs(int x, int y, int cnt, String tmp) {
		if(cnt == 5) {
			if(!list.contains(tmp)) {
				list.add(tmp);
			}
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if((0<=nx&&nx<5)&&(0<=ny&&ny<5)) {
				dfs(nx, ny, cnt+1, tmp+arr[nx][ny]);
			}
		}
	}
}