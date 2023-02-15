import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 첫 번째 기둥
		Stack<Integer> s1 = new Stack<>();
		// 두 번째 기둥
		Stack<Integer> s2 = new Stack<>();
		
		// 가장 큰 원판
		int N = Integer.parseInt(br.readLine());
		
		// 원판 설정
		int bigNum = N;
		// count 변수 선언 및 초기화
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N; i++) {
			s1.add(Integer.parseInt(st.nextToken()));
		}
		while (bigNum > 0) {
			if (s1.contains(bigNum)) {
				while (s1.size() > 0) {
					// 맨 위에 있는 원판
					int plate = s1.pop();
					// 맨 위 원판이 가장 큰 원판일 때 3번째 기둥으로 옮긴다.
					// 그 다음으로 큰 원판으로 만들어준다.
					// while문 종료
					if (plate == bigNum) {
						sb.append("1 3\n");
						cnt++;
						bigNum--;
						break;
					// 가장 큰 원판이 나올 때 까지
					// 2번재 기둥으로 옮긴다.
					} else {
						sb.append("1 2\n");
						cnt++;
						s2.add(plate);
					}
				}
			// 위와 같은 logic	
			} else if (s2.contains(bigNum)) {
				while (s2.size() > 0) {
					int plate = s2.pop();
					if (plate == bigNum) {
						sb.append("2 3\n");
						cnt++;
						bigNum--;
						break;
					} else {
						sb.append("2 1\n");
						cnt++;
						s1.add(plate);
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}
