import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] isused1 = new boolean[40];
	static boolean[] isused2 = new boolean[40];
	static boolean[] isused3 = new boolean[40];
	static int cnt = 0;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		func(0);
		System.out.println(cnt);
	}
	
	public static void func(int num) {
		if (num == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isused1[i] || isused2[i+num] || isused3[num-i+N-1]) continue;
			isused1[i] = true;
			isused2[i + num] = true;
			isused3[num-i+N-1] = true;
			func(num+1);
			isused1[i] = false;
			isused2[i + num] = false;
			isused3[num-i+N-1] = false;
		}
	}
}