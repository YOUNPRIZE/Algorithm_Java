import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 낮은 숫자가 우선 순위인 int형 우선순위 큐 선언
		// 양수로 된 값 담기
		PriorityQueue<Integer> pqLow = new PriorityQueue<>();
		
		// 높은 숫자가 우선 순위인 int형 우선순위 큐 선언
		// 음수로 된 값 담기
		PriorityQueue<Integer> pqHigh = new PriorityQueue<>(Collections.reverseOrder());
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int X = Integer.parseInt(br.readLine());
			if (X > 0) {
				pqLow.add(X);
			} else if (X < 0) {
				pqHigh.add(X);
			// X가 0일 때
			} else {
				if (pqLow.size() == 0 && pqHigh.size() == 0) {
					sb.append(0).append("\n");
				} else if (pqLow.size() == 0) {
					sb.append(pqHigh.remove()).append("\n");
				} else if (pqHigh.size() == 0) {
					sb.append(pqLow.remove()).append("\n");
				} else {
					if (Math.abs(pqLow.peek()) > Math.abs(pqHigh.peek())) {
						sb.append(pqHigh.remove()).append("\n");
					} else if (Math.abs(pqLow.peek()) < Math.abs(pqHigh.peek())) {
						sb.append(pqLow.remove()).append("\n");
					} else {
						if (pqLow.peek()>pqHigh.peek()) {
							sb.append(pqHigh.remove()).append("\n");
						} else {
							sb.append(pqLow.remove()).append("\n");
						}
					}
				}
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
		br.close();
	}
}
