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
		
		Long N = Long.parseLong(st.nextToken());
		Long M = Long.parseLong(st.nextToken());
		
		ArrayList<Long> arr = new ArrayList<Long>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(Long.parseLong(st.nextToken()));
		}
		
		long start = Collections.max(arr);
		long end = 1000000000;
		
		while (start <= end) {
			long mid = (start + end) / 2;
			long min = 0; 
			int cnt = 0;
			for (int i = 0; i < arr.size(); i++) {
				if (mid < min + arr.get(i)) {
					cnt++;
					min = arr.get(i);
				} else min += arr.get(i);
			}
			cnt++;
			if (cnt > M) start = mid + 1;
			else end = mid - 1;
		}
		System.out.println(start);
	}
}
