import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		
		for (int tc = 1; tc <= T; tc++) {
			Character[][] arr = new Character[5][15];
			int length = 0;
			
			for (int i = 0 ; i < 5; i++) {
				String str = sc.next();
				
				length = (str.length() > length) ? str.length() : length;
				
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < 5; j++) {
					if (arr[j][i] == null) System.out.print("");
					else System.out.print(arr[j][i]);
				}
			}
			System.out.println();
		}
	}
}