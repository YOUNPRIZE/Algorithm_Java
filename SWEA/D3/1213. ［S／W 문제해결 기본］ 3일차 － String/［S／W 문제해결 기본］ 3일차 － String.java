import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			String find = sc.next();
			String search = sc.next();
			int index = 0;
			int cnt = 0;
			while (index != search.length() - 1 ) {
				boolean check = true;
				for (int i = 0; i < find.length(); i++) {
					if (find.charAt(i) != search.charAt(i+index)) {
						check = false;
						break;
					}
				}
				if (check) {
					index = index + find.length()-1;
					cnt++;
				} else index++;
			}
			System.out.printf("#%d %d\n", T, cnt);
		}
	}
}