import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] check;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		check = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		nextPerm();
		System.out.println(sb.toString());
	}
	
	public static void nextPerm() {
		boolean flag1 = false;
		int peak = 0;
		for (int i = N - 1; i >= 1; i--) {
			if (check[i] > check[i-1]) {
				peak = i;
				flag1 = true;
				break;
			}
		}
//		System.out.println(peak);
		if (!flag1) {
			sb.append(-1);
			return;
		}
		for (int i = N - 1; i > peak - 1; i--) {
			if (check[i] > check[peak - 1]) {
				int temp = check[i];
//				System.out.println(temp);
				check[i] = check[peak - 1];
				check[peak - 1] = temp;
				break;
			}
		}
//		System.out.println(Arrays.toString(check));
		for (int i = peak; i < N-1; i++) {
			int min = i;
			for (int l = i + 1; l < N; l++) {
				if(check[min] > check[l]) min = l;
			}
			int tempo = check[i];
			check[i] = check[min];
			check[min] = tempo;
		}
		
		for (int x : check) {
			sb.append(x).append(" ");
		}
	}
}