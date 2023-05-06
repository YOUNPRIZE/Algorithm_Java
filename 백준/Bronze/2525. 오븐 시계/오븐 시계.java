import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int hour = 0;
		
		if (C >= 60) {
			hour = C / 60;
			C = C - 60 * hour;
		}
		
		A = A + hour;
		
		
		B = B + C;
		
		if (B >= 60) {
			B = B - 60;
			A++;
		}
		A = A % 24;
		System.out.println(A + " " + B);
	}
}