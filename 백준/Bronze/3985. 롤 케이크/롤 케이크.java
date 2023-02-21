
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int[] arr = new int[L+1];
		int N = sc.nextInt();
		int[] count = new int[N+1];
		
		int sum = 0;
		int original = 0;
		
		for (int i = 1; i <= N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			for (int j = start; j <= end; j++) {
				if (arr[j] == 0) arr[j] = i;
			}
			int expect = end - start + 1;
			if (expect > sum) {
				sum = expect;
				original = i;
			}
		}
		
		for (int i = 1; i <= L; i++) {
			if (arr[i] > 0) count[arr[i]] += 1;
			
		}
		int real = 0;
		int realSum = 0;
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] > realSum) {
				real = i;
				realSum = count[i];
			}
		}
		System.out.println(original);
		System.out.println(real);
	}
}
