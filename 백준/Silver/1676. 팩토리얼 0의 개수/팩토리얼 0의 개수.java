import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//int K = factorial(N);
		
		//String str = String.valueOf(K);
		
		int cnt = 0;
		
		while (N >= 5) {
			cnt += N / 5;
			N /= 5;
		}
		System.out.println(cnt);
	}
//	
//	public static int factorial(int N) {
//		if(N == 0) return 0;
//		else if (N==1) return 1;
//		else if (N==2) return 2;
//		return N * factorial(N-1);
//	}
}