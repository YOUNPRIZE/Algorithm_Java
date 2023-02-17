import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sbRow;
		StringBuilder sbCol; 
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			sbRow = new StringBuilder();
			sbCol = new StringBuilder();
			char[][] arr = new char[100][100];
			
			for (int i = 0; i < 100; i++) {
				String sentence = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sentence.charAt(j);
				}
			}
			
			int max = 0;
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sbRow.append(arr[i][j]);
					sbCol.append(arr[i][j]);
					//int cntR = 0;
					//int cntC = 0;
					
					for (int k = 1; j+k < 100; k++) {
						sbRow.append(arr[i][j+k]);
						if (palindrome(sbRow.toString()) > max) max = palindrome(sbRow.toString());
					}
					
					for (int k = 1; i+k < 100; k++) {
						sbCol.append(arr[i+k][j]);
						if (palindrome(sbCol.toString()) > max) max = palindrome(sbCol.toString());
					}
					
					// 회문이면 문자열 길이 리턴, 회문이 아니면 0 리턴
					//cntR = palindrome(sbRow.toString());
					//cntC = palindrome(sbCol.toString());
//					int x = (cntR > cntC) ? cntR : cntC;
//					max = (x > max) ? x : max;
					sbRow.setLength(0);
					sbCol.setLength(0);
				}
			}
			System.out.printf("#%d %d\n", N, max);
		}
	}
	
	static int palindrome(String str) {
		boolean check = true;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length()-1-i)) {
				check = false;
				break;
			}
		}
		if (check) return str.length();
		else return 0;
	}
}