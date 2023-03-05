import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static boolean[] visit;
	static int length;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str.equals("0")) break;
			String[] strArr = str.split(" ");
			length = Integer.parseInt(strArr[0]);
			arr = new int[length];
			visit = new boolean[length];
			for (int i = 0; i < length; i++) {
				arr[i] = Integer.parseInt(strArr[i+1]);
			}
			dfs(0, 0);
			System.out.println();
		}
	}
	
	public static void dfs(int num, int depth) {
		if (depth == 6) {
			for (int i = 0; i < length; i++) {
				if (visit[i]) System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = num; i < length; i++) {
			visit[i] = true;
			dfs(i + 1, depth + 1);
			visit[i] = false;
		}
	}
}