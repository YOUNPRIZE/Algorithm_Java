import java.io.*;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= K; i++) {
			int temp = N * i;
			String s = String.valueOf(temp);
			StringBuilder sb = new StringBuilder();
			for(int j = s.length()-1; j >= 0; j--) {
				sb.append(s.charAt(j));
			}
			
			max = Math.max(max, Integer.parseInt(sb.toString()));
		}
		System.out.println(max);
	}
 
}