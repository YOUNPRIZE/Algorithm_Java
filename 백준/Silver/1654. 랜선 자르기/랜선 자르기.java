import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<Long> arr = new ArrayList<Long>();
		
		for (int i = 0; i < K; i++) {
			arr.add(Long.parseLong(br.readLine()));
		}
		
		long start = 1;
		long end = Collections.max(arr);
		
		while (start <= end) {
			long mid = (start + end) /2;
			int lines = 0;
			for (long i : arr) {
				lines += i / mid;
			}
			if (lines >= N) start = mid + 1;
			else end = mid - 1;
		}
		System.out.println(end);
	}
}
