import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (map.get(num) != null) {
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
		}
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num2 = Integer.parseInt(st.nextToken());
			if (map.get(num2) != null) {
				sb.append(map.get(num2)).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
}
