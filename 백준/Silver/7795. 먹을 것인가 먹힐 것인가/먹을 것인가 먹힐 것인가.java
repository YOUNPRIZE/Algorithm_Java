
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arrN = new int[N];
			int[] arrM = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arrN[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arrM[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arrN);
			Arrays.sort(arrM);
			
			int cnt = 0;
			for (int i : arrN) {
				for (int j : arrM) {
					if (i <= j) break;
					else cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}
}
