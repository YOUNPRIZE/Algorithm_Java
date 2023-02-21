
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[1002][1002];
		
		int tc;
		
		for (tc = 1; tc <= N; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x + w; i++) {
				for (int j = y; j < y + h; j++) {
					arr[i][j] = tc;
				}
			}
		}
		
		for (int k = 1; k < tc; k++) {
			//System.out.println(k);
			int sum = 0;
			for (int i = 0; i < 1002; i++) {
				for (int j = 0; j < 1002; j++) {
					if (arr[i][j] == k) sum++;
				}
			}
			System.out.println(sum);
		}
	}
}
