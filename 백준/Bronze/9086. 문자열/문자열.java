
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		
		for (int i = 0; i < T; i++) {
			String str = sc.next();
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(str.charAt(0)).append(str.charAt(str.length()-1));
			
			System.out.println(sb.toString());
		}
	}
}
