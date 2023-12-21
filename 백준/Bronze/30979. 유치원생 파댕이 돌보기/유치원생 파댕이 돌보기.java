import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int flavor = Integer.parseInt(st.nextToken());
			sum += flavor;
		}
		if (T > sum) System.out.println("Padaeng_i Cry");
		else System.out.println("Padaeng_i Happy");
	}
}