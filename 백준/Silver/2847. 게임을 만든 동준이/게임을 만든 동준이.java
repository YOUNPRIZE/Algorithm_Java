import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] level = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			level[i] = sc.nextInt();
			if (i == N-1) max = level[i];
		}
		int cnt = 0;
		for (int i = N-2; i >= 0; i--) {
			if (level[i] >= max) {
				cnt += level[i] - (max - 1);
				max--; 
			} else {
				max = level[i];
			}
		}
		System.out.println(cnt);
	}
}
