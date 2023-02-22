import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[7][2];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 여학생은 0, 남학생은 1
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			arr[grade][s]++;
		}
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				sum += arr[i][j] / K;
				if (arr[i][j] % K > 0) sum++;
			}
		}
		System.out.println(sum);
	}
}