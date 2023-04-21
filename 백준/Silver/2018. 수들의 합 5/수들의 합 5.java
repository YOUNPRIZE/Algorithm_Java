import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0;
		int ep = 0;
		int sum = 0;
		
		for (int i = 1; i <= N; i++) {
			while (sum < N && ep <= N) {
				sum += ep;
				ep++;
			}
			
			if (sum == N) cnt++;
			
			sum -= i;
		}
		System.out.println(cnt);
	}
}