import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			for (int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
			}
			sb.append(V-1).append("\n");
		}
		System.out.println(sb.toString());
	}
}