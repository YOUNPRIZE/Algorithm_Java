import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if (A == 0 && B < 45) {
			System.out.printf("%d %d", 23, 60-(45-B));
		} else if (B < 45) {
			System.out.printf("%d %d", A-1, 60-(45-B));
		} else {
			System.out.printf("%d %d", A, B-45);
		}
	}
}