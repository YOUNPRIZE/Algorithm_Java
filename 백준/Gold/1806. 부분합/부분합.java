import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int endPoint = 0;
		int sum = arr[0];
		int len = 100000;
		
		for (int i = 0; i < N; i++) {
			while(endPoint < N && sum < S) {
				endPoint++;
				if (endPoint != N) sum += arr[endPoint];
				
//				if (endPoint == 11) System.out.println(sum);
//				System.out.println(endPoint);
			}
			
//			if (sum == S) {
//				len = Math.min(len, endPoint - i);
//				System.out.println("endPoint : " + endPoint);
//				System.out.println("startPoint : " + i);
//				System.out.println();
//			}
			if (endPoint == N) break;
			len = Math.min(len, endPoint - i + 1);
			sum -= arr[i];
		}
		if (len == 100000) System.out.println(0);
		else System.out.println(len);
	}
}