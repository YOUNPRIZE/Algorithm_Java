
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arrA = new int[4];
			int[] arrB = new int[4];
			for (int j = 0; j < 4; j++) {
				arrA[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 4; j++) {
				arrB[j] = Integer.parseInt(st.nextToken());
			}
			// 공통부분 X
			if (arrB[1] > arrA[3] || arrB[0] > arrA[2] || arrB[3] < arrA[1] || arrB[2] < arrA[0]) {
				System.out.println("d");
			// 점
			} else if ((arrA[2] == arrB[0] && arrA[3] == arrB[1]) || (arrB[2] == arrA[0] && arrB[3] == arrA[1]) || (arrA[0] == arrB[2] && arrA[3] == arrB[1]) || (arrA[2] == arrB[0] && arrA[1] == arrB[3])) {
				System.out.println("c");
			} else if (arrA[3] == arrB[1] || arrB[3] == arrA[1] || arrA[2] == arrB[0] || arrA[0] == arrB[2]) {
				System.out.println("b");
			} else System.out.println("a");
		}
	}
	
}
