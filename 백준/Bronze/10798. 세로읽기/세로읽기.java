import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][15];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 5; i++) {
			String str = sc.nextLine();
			max = Math.max(max, str.length());
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] != '\u0000') System.out.print(arr[j][i]);
			}
		}
	}
}