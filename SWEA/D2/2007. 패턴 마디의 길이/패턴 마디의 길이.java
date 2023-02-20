import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Character[] arr;
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			arr = new Character[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}
			
			String repeat = "";
			
			for (int i = 0; i < arr.length; i++) {
				if (i == 0) repeat = repeat + arr[i];
				else {
					boolean check = true;
					for (int j = 0; j < repeat.length(); j++) {
						if (repeat.charAt(j) != arr[i+j]) {
							check = false;
							break;
						}
					}
					if (check) {
						break;
					}
					repeat = repeat + arr[i];
				}
			}
			System.out.printf("#%d %d\n", tc, repeat.length());
		}
	}
}