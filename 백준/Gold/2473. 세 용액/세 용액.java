import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] solutions, result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		solutions = new long[N];
		result = new long[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solutions[i] = Long.parseLong(st.nextToken());
		}
		
//		Arrays.toString(solutions);
		
		
		Arrays.sort(solutions);
		
		long ans = Long.MAX_VALUE;
		
		loop: for (int first = 0; first < N - 2; first++) {
			
			int start = first + 1;
			int end = N - 1;
			
			while(start < end) {
				long sum = solutions[first] + solutions[start] + solutions[end];
				if (ans > Math.abs(sum)) {
					ans = Math.abs(sum);
					result[0] = solutions[first];
					result[1] = solutions[start];
					result[2] = solutions[end];
					
					if (sum == 0) break loop;
				}
				if (sum < 0) start++; 
				else end--;
			}
		}
		System.out.println(result[0] + " " + result[1] + " " + result[2]);
	}
}