import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] res = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int cnt = arr[i];
			for (int j = 1; j <= N; j++) {
				if (res[j] != 0) continue;
				if (cnt > 0) {
					cnt--;
					continue;
				} else {
					res[j] = i;
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) sb.append(res[i]).append(" ");
		System.out.println(sb.toString());
	}
}