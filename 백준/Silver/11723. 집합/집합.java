import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[21];
		
		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			String order = str[0];
			int x = 0;
			if (!order.equals("all") && !order.equals("empty")) x = Integer.parseInt(str[1]);
			switch(order) {
			case "add":
				if (arr[x] == 0) arr[x] = 1;
				break;
			case "remove":
				if (arr[x] == 1) arr[x] = 0;
				break;
			case "check":
				if (arr[x] == 1) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "toggle":
				if (arr[x] == 1) arr[x] = 0;
				else arr[x] = 1;
				break;
			case "all":
				Arrays.fill(arr, 1);
				break;
			case "empty":
				Arrays.fill(arr, 0);
				break;
			default:
				break;
			}
		}
		System.out.println(sb.toString());
	}
}