import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Main {
	static int N, M;
	static HashMap<String, String[]> idols;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		idols = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			int members = Integer.parseInt(br.readLine());
			idols.put(name, new String[members]);
			for (int j = 0; j < members; j++) {
				idols.get(name)[j] = br.readLine();
			}
		}
		
		Set<String> keySet = idols.keySet();
		
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			int game = Integer.parseInt(br.readLine());
			// 사람 이름
			if (game == 1) {
				loop: for (String key : keySet) {
					String[] temp = idols.get(key);
					for (int j = 0; j < temp.length; j++) {
						if (temp[j].equals(name)) {
//							System.out.println(key);
							sb.append(key).append("\n");
							break loop;
						}
					}
				}
			// 그룹 이름
			} else {
				String[] temp = idols.get(name);
				Arrays.sort(temp);
				for (int j = 0; j < temp.length; j++) {
//					System.out.println(temp[j]);
					sb.append(temp[j]).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}