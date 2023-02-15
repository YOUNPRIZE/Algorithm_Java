import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int res = 0;
		for(int i=0; i<10; i++) {
			int a = sc.nextInt();
			if(sum < 100){
				sum+=a;
				if(Math.abs(res - 100) > Math.abs(sum - 100)) {
					res = sum;
				} else if(Math.abs(res - 100) == Math.abs(sum - 100)) {
					res = res > sum ? res : sum;
				}
			}
		}
		System.out.println(res);
	}
}
