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
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		arr[0] = 1;
		int cnt = 0;
		int location = 0;
		while (true) {
			if (arr[location] == 0 || arr[location] % 2 == 0) {
				location -= L;
			} else location += L;
			
			
			if (location >= N) location -= N;
			else if (location < 0) location += N;
			arr[location]++;
			cnt++;
			if (arr[location] == M) break;
		}
		if (M == 1) System.out.println(0);
		else System.out.println(cnt);
	}
}
