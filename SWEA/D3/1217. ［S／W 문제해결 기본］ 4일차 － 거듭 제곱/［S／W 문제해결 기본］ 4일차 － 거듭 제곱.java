import java.util.Scanner;

public class Solution {
	static int cal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
            System.out.printf("#%d ", tc);
			System.out.println(pow(A, B));
		}
	}
	
	public static int pow(int down, int up) {
		if (up == 1) return down;
		
		if (up % 2 == 0) {
			int div = pow(down, up/2);
			return div * div;
		} else {
			int div = pow(down, (up-1)/2);
			return div*div*down;
		}
	}
}