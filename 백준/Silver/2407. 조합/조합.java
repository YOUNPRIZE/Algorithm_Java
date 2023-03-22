import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static long result;
	static int N,M,A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		A = N - M;
		
		result = 1;
		BigInteger bigNumber = new BigInteger("1");
//		System.out.println(result);
		while(N > A) {
//			result *= N--;
//			BigInteger temp = BigInteger.valueOf(N--);
			String str = Integer.toString(N--);
			BigInteger temp = new BigInteger(str);
//			System.out.println(temp);
			bigNumber = bigNumber.multiply(temp);
//			System.out.println(bigNumber);
//			System.out.println(N);
//			System.out.println(N);
//			System.out.println(result);
		}
//		System.out.println(result);
//		System.out.println(result);
		while (M > 0) {
//			result /= M--;
//			BigInteger temp = BigInteger.valueOf(M--);
			String str = Integer.toString(M--);
			BigInteger temp = new BigInteger(str);
//			System.out.println(temp);
			bigNumber = bigNumber.divide(temp);
//			System.out.println(M);
//			System.out.println(result);
		}
		
		System.out.println(bigNumber);
	}
}