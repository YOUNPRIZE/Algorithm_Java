
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int[] arr = new int[str.length()+1];
		
		int small = 0;
		
		for (int i = 1; i <= str.length(); i++) {
			if (str.length() % i == 0) {
				int result = str.length() / i;
				if (arr[result] != 0) break;
				small = result;
				arr[i] = result;
			}
		}
		
		
		
		int big = str.length() / small;
		
		char[][] arr2 = new char[big][small];
		
		int index = 0;
		
//		System.out.println(small);
//		System.out.println();
		
		for (int i = 0; i < small; i++ ) {
			for (int j = 0; j < big; j++) {
				arr2[j][i] = str.charAt(index++);
			}
		}
		
		for (int i = 0; i < big; i++ ) {
			for (int j = 0; j < small; j++) {
				System.out.print(arr2[i][j]);
			}
		}
	}
}
