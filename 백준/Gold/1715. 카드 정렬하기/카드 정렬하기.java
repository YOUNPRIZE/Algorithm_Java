import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(num);
		}
		int cnt = 0;
		while(pq.size() > 1) {
			int A = pq.poll();
			int B = pq.poll();
			
			int AB = A + B;
			cnt += AB;
			pq.add(AB);
		}
		System.out.println(cnt);
	}
}