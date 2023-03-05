import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			long sum = 0;
			
			int sell = 0;
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) arr[i]=sc.nextInt();
			
			for (int i = N-1; i >= 0; i--) {
				
				if (arr[i] > sell) sell = arr[i];
				
				sum += sell-arr[i];
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
		sc.close();
	}
	
	
}