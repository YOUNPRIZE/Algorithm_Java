import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static PriorityQueue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc<=T; tc++) {
			System.out.printf("#%d ", tc);
			q = new PriorityQueue<>(Collections.reverseOrder());
			int N = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				int num1 = sc.nextInt();
				if (num1 == 1) {
					int num2 = sc.nextInt();
					q.add(num2);
				} else {
					if (q.size() > 0) {
						System.out.printf("%d ", q.poll());
					} else {
						System.out.printf("%d ", -1);
					}
				}
			}
			System.out.println();
		}
	}
}