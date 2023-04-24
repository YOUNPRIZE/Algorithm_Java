import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] sols;
	static int N;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sols = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sols[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sols);
		
		int ans = INF;
		
//		loop: for (int i = 0; i < N - 2; i++) {
			int start = 0;
			int end = N - 1;
			
			while(start < end) {
				int sum = sols[start] + sols[end];
				
				if (Math.abs(ans) > Math.abs(sum)) {
					ans = sum;
					if (ans == 0) break;
				} 
				
				if (sum < 0) start++;
				else end--;
			}
//		}
		System.out.println(ans);
	}
}