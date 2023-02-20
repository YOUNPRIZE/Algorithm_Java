import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			
			String[] arr = sc.next().split("\\+");
			
			int sum = 0;
			
			for (int i = 0; i < arr.length; i++) {
				sum += Integer.parseInt(arr[i]);
			}
			
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}