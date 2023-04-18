import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 제일 작은 값을 poll 하는 우선순위큐 선언 및 초기화
		PriorityQueue<Integer> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (q.size() == 0) sb.append(0).append("\n");
				else sb.append(q.poll()).append("\n");
			}
			else q.add(num);
		}
		System.out.println(sb.toString());
	}
}