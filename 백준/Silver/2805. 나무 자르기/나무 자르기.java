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
		
		st = new StringTokenizer(br.readLine());
		
		int max = 0;
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i]) max = arr[i];
		}
		int start = 0; int end = max;
		while (start < end) {
			long trees = 0;
			int mid = (start + end) / 2;
			
			for (int i : arr) {
				if (i > mid) trees += (i - mid);
			}
			
			if (trees < M) end = mid;
			else start = mid + 1;
		}
		System.out.println(end-1);
	}
}
