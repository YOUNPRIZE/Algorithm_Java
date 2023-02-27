import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			int temp = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (arr[i] > arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				System.out.printf("%d ", arr[i]);
			}
			System.out.println();
		}
	}
}