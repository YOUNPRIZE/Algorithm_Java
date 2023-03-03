import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			// N명
			int N = sc.nextInt();
			// M초의 시간을 들이면
			int M = sc.nextInt();
			// K개의 붕어빵을 만들 수 있다.
			int K = sc.nextInt();
			
			int[] cus = new int[N];
			
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				cus[i] = sc.nextInt();
				if (cus[i] > max) max = cus[i];
			}
			
			int[] bread = new int[max+1];
			
			for (int i = 1; i <= max; i++) {
				if (i % M == 0) bread[i] = K;
			}
			
			for (int i : cus) {
				bread[i] += -1;
			}
			
			int cnt = 0;
			boolean give = true;
			
			for (int i : bread) {
				cnt += i;
				if (cnt < 0) {
					give = false;
					break;
				}
			}
			
			if (give) System.out.println("Possible");
			else System.out.println("Impossible");
			
		}
	}
}