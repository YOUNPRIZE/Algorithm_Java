import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sbRow;
		StringBuilder sbCol; 
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			sbRow = new StringBuilder();
			sbCol = new StringBuilder();
			char[][] arr = new char[8][8];
			
			for (int i = 0; i < 8; i++) {
				String sentence = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = sentence.charAt(j);
				}
			}
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if(i <= 8-N+1 || j <= 8-N+1) {
						sbRow.append(arr[i][j]);
						sbCol.append(arr[i][j]);
						
						if (i >= 8 - N + 1) {
							for (int k = 1; k < N && j+k < 8; k++) {
								sbRow.append(arr[i][j+k]);
							}
						}
						else if (j >= 8 - N + 1) {
							for (int k = 1; k < N && i+k < 8; k++) {
								sbCol.append(arr[i+k][j]);
							}
						} else {
							for (int k = 1; k < N && j+k < 8 && i+k < 8; k++) {
								sbRow.append(arr[i][j+k]);
								sbCol.append(arr[i+k][j]);
							}
						}
						// 여기에 메소드 넣고
						if (sbRow.toString().length() == N) palindrome(sbRow.toString());
						if (sbCol.toString().length() == N) palindrome(sbCol.toString());
						sbRow.setLength(0);
						sbCol.setLength(0);
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, cnt);
			cnt = 0;
		}
	}
	
	static void palindrome(String str) {
		boolean check = true;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length()-1-i)) {
				check = false;
				break;
			}
		}
		if (check) cnt++;
	}
}