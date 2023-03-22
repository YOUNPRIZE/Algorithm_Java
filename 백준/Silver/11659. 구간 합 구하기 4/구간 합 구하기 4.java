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
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			if (i == 0) arr[i] = Integer.parseInt(st.nextToken());
			else arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			
			int B = Integer.parseInt(AB[1]);
			if (A == 1) {
//				System.out.println(arr[B-1]);
				sb.append(arr[B-1]).append("\n");
			} else {
//				System.out.println(arr[B-1] - arr[A-2]);
				sb.append(arr[B-1] - arr[A-2]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}