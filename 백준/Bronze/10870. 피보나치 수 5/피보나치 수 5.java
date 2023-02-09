import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		
		//int N = sc.nextInt();
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
		System.out.println(Fibonacci(N));	
	}
	
	static int Fibonacci(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		return Fibonacci(N-1) + Fibonacci(N-2);
	}
}
