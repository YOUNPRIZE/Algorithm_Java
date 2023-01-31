import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
	}
	
	public static int factorial(int N) {
		int result = 0;
		if (N == 1) {
			return 1;
		} else if (N == 0) {
			return 1;
		} else {
			result = N * factorial(N-1);
		}
		return result;
	}
}
