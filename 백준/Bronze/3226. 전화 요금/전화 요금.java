import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] time = st.nextToken().split(":");
			int hour = Integer.parseInt(time[0]);
			int min = Integer.parseInt(time[1]);
			
			int call = Integer.parseInt(st.nextToken());
			
			
			if (min + call >= 60) {
				int first = 60 - min;
				if (hour >= 7 && hour < 19) res += first * 10;
				else res += first * 5;
				int second = min + call - 60;
				hour++;
				if (hour >= 7 && hour < 19) res += second * 10;
				else res += second * 5;
			} else {
				if (hour >= 7 && hour < 19) res += call * 10;
				else res += call * 5;
			}
		}
		System.out.println(res);
	} 
}