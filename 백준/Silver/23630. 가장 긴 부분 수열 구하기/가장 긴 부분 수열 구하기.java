import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[] arr, bitCount;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bitCount = new int[32];
		
		for (int i = 0; i < N; i++) {
			int temp = arr[i];
			int j = 0;
			while (temp > 0) {
				bitCount[j] += (temp % 2);
				temp = temp / 2;
				j++;
			}
		}
		
		int maxBitCount = 0;
		
		for (int i = 0; i < 32; i++) {
			if (bitCount[i] > maxBitCount) maxBitCount = bitCount[i];
		}
		System.out.println(maxBitCount);
	}
}