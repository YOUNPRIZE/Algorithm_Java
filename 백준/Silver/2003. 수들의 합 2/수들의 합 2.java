import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
	
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int endPoint = 0;
		int sum = 0;
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			while(sum < M && endPoint <= N) {
				sum += arr[endPoint];
				endPoint++;
			}
			
			if (sum == M) cnt++;
			
			sum -= arr[i];
		}
		
		System.out.println(cnt);
	}
}