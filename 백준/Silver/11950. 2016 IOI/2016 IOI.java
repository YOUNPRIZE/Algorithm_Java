import java.util.Scanner;
// 4613. 러시아 국기 같은 깃발
public class Main {
	static int N, M;
	static String[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new String[N+1];
			
			for (int i = 1; i <= N; i++) {
				arr[i] = sc.next();
			}
			
			int change = Integer.MAX_VALUE;
			int sumW = 0;
			int sumB = 0;
			int sumR = 0;
			
			// 모든 경우의 수의 합을 비교해서 제일 작은 숫자를 찾는다.
			for (int i = 1; i <= N-2; i++) {
				sumW += arr[i].replace("W", "").length();
				for (int j = i + 1; j <= N-1; j++) {
					sumB += arr[j].replace("B", "").length();
					for (int k = j + 1; k <= N; k++) {
						sumR += arr[k].replace("R", "").length();
					}
					if (change > (sumW + sumB + sumR)) {
						change = sumW + sumB + sumR;
					}
					sumR = 0;
				}
				sumB = 0;
			}
			System.out.println(change);
	}
}