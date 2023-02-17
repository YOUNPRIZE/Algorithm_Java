import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			boolean check = true;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length()-1-i)) {
					check = false;
					break;
				}
			}
			if (check) System.out.printf("#%d %d\n", test_case, 1);
			else System.out.printf("#%d %d\n", test_case, 0);
		}
	}
}