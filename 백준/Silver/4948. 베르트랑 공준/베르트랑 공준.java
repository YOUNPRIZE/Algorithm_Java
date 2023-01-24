import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] prime = new int[246913];
		
		for (int i = 2; i <= 246912; i++) prime[i] = i;
		
		for (int i = 2; i <= 246912; i++) {
			if (prime[i] == 0) continue;
			
			for (int j = 2*i; j <= 246912; j+=i) {
				prime[j] = 0;
			}
		}
		
		while (true) {
			int n = sc.nextInt();
			int cnt = 0;
			if (n == 0) break;
			
			for (int i = n + 1; i <= 2*n; i++) {
				if (prime[i] != 0) cnt++;
			}
			
			System.out.println(cnt);
		}
	}
}
