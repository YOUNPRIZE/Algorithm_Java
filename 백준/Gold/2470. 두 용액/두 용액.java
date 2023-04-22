import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] sol;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sol = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) sol[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(sol);
		
		int[] result = new int[2];
		
		int start = 0;
		int end = N - 1;
		int min = INF;
		
		while(start < end) {
			int sum = sol[start] + sol[end];
			
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				result[0] = sol[start];
				result[1] = sol[end];
				
				if (sum == 0) break;
			}
			
			if (sum < 0) start++; 
			else end--;
		}
		System.out.println(result[0] + " " + result[1]);
	}
}