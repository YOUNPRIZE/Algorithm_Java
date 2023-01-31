import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(Fibonacci(N));	
	}
	
	static int Fibonacci(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		return Fibonacci(N-1) + Fibonacci(N-2);
	}
}
