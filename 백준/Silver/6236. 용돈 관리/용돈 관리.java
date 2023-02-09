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
		
		int max = 0;
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
        
		int start = max;
		int end = 10000 * 100000;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 1; int money = mid;
			for (int i = 0; i < N; i++) {
				if (arr[i] > money) {
					money = mid;
					cnt++;
					money = money - arr[i];
				} else {
					money = money - arr[i];
				}
			}
			if (cnt > M) start = mid + 1;
			else end = mid - 1;
		}
		System.out.println(start);
	}
}
