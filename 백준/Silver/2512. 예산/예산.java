import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Long> arr = new ArrayList<Long>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(Long.parseLong(st.nextToken()));
		}
		
		int highCost = Integer.parseInt(br.readLine());

		
		long start = 1; long end = Collections.max(arr);
		
		while(start <= end) {
			Long mid = (start + end) / 2;
			int cost = 0;
			for (Long i : arr) {
				if (i < mid) cost += i;
				else cost += mid;
			}
			if (cost > highCost) end = mid - 1;
			else start = mid + 1;
		}
		System.out.println(end);
	}
}