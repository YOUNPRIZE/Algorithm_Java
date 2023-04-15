import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
//		int N = Integer.parseInt(br.readLine());
		if (N == 4 || N == 7) {
			System.out.println(-1);
		}
		else if (N % 5 == 0) {
			System.out.println(N / 5);
		}
		else if (N % 5 == 1 || N % 5 == 3) {
			System.out.println((N / 5) + 1);
		}
		else if (N % 5 == 2 || N % 5 == 4) {
			System.out.println((N / 5) + 2);
		}
	}
}