import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			String str = sc.next();
			
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < N; k++) {
					sb.append(str.charAt(j));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}