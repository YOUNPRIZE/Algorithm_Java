import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			set.add(str);
		}
		
		int include = 0;
		
		for (int i = 0; i < M; i++) {
//			int cur = set.size();
			String str = br.readLine();
			if (set.contains(str)) include++;
//			set.add(str);
//			int pushed = set.size();
//			if (cur == pushed) include++;
		}
		System.out.println(include);
	}
}
