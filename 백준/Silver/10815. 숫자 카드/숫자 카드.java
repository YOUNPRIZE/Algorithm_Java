import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		HashSet<Integer> set = new HashSet<Integer>();
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int size = set.size();
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			set.add(Integer.parseInt(st.nextToken()));
			if (size == set.size()) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
				size++;
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
}
