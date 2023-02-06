import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		StringTokenizer st;
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch (order) {
				case "push_front":
					int number = Integer.parseInt(st.nextToken());
					dq.addFirst(number);
					break;
				case "push_back":
					int number2 = Integer.parseInt(st.nextToken());
					dq.addLast(number2);
					break;
				case "pop_front":
					if (dq.size() == 0) sb.append(-1).append("\n");
					else sb.append(dq.removeFirst()).append("\n");
					break;
				case "pop_back":
					if (dq.size() == 0) sb.append(-1).append("\n");
					else sb.append(dq.removeLast()).append("\n");
					break;
				case "size":
					sb.append(dq.size()).append("\n");
					break;
				case "empty":
					if (dq.size() == 0) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "front":
					if (dq.size() == 0) sb.append(-1).append("\n");
					else sb.append(dq.peekFirst()).append("\n");
					break;
				case "back":
					if (dq.size() == 0) sb.append(-1).append("\n");
					else sb.append(dq.peekLast()).append("\n");
					break;
			}
		}
		System.out.println(sb.toString());
	}
}
