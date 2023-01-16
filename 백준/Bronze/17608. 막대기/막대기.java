import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
        int cnt = 1;
        int stick = arr[arr.length - 1];
        
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > stick) {
				cnt++;
                stick = arr[i];
			}
		}
		System.out.print(cnt);
        sc.close();
    }
}