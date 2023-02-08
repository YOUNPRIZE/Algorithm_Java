import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 개수 T
		int T = Integer.parseInt(br.readLine());
		
		// T만큼 반복
		for (int k = 0; k < T; k++) {
			// 수첩 1에 적어 놓은 정수의 개수
			int N = Integer.parseInt(br.readLine());
			
			// 수첩에 담을 hashset 선언
			HashSet<Integer> arr = new HashSet<>();
			
			st = new StringTokenizer(br.readLine());
			// 수첩에 숫자 삽입
			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			// 수첩 2에 적어 놓은 정수의 개수
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			// hashset에 삽입하면서 존재 유무 비교
			for (int i = 0; i < M; i++) {
                // 원래 코드
                // 굳이 한 번 더 삽입하려고 해서 틀렸던 것
                //size = arr.size();
				//arr.add(Integer.parseInt(st.nextToken()));
				//if (arr.size() > size) {
				//	sb.append(0).append("\n");
				//} else {
				//	sb.append(1).append("\n");
				//}
				sb.append(arr.contains(Integer.parseInt(st.nextToken()))? 1 : 0).append("\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
}
