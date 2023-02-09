import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int t[];
	static int p[];
	static int N;
	static int result = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		t = new int[N];
		p = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0,0);
		
		System.out.println(result);
	}
	
	static void func(int idx, int sum) {
		if (idx == N) {
			result = (result < sum) ? sum : result;
			return;
		}
		
		if (idx > N) return;
		
		func(idx + t[idx], sum + p[idx]);
		
		func(idx+1, sum);
	}
}
