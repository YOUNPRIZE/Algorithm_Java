import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<String> q1 = new LinkedList<>();
		Queue<String> q2 = new LinkedList<>();
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			int N = sc.nextInt();
			
			for (int i = 1; i <= N; i++) {
				String str = sc.next();
				if (i <= N - (N / 2)) q1.add(str);
				else q2.add(str);
			}
			
			while (!q1.isEmpty() || !q2.isEmpty()) {
				if (!q1.isEmpty()) System.out.printf("%s ",q1.remove());
				if (!q2.isEmpty()) System.out.printf("%s ",q2.remove());
			}
			System.out.println();
		}
		
	}
}