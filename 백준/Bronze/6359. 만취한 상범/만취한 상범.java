import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[] jail = new int[N+1];
			// 0 이 닫힌거, 1이 열린거
			for (int i = 1; i <= N; i++) {
				for (int j = i; j <= N; j = j + i) {
					if (jail[j] == 0) jail[j] = 1;
					else jail[j] = 0;
				}
			}
			int run = 0;
			for (int i = 1; i <= N; i++) {
				if (jail[i] == 1) run++;
			}
			sb.append(run).append("\n");
		}
		System.out.println(sb.toString());
	}
}