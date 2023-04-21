import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		N = Integer.parseInt(strArr[0]);
		M = Integer.parseInt(strArr[1]);
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int ep = 0;
		
		int min = Integer.MAX_VALUE;
		
		for (int sp = 0; sp < N; sp++) {
			while(ep < N && arr[ep] - arr[sp] < M) ep++;
			if(ep == N) break;
			min = Math.min(min, arr[ep] - arr[sp]);
		}
		System.out.println(min);
	}
}