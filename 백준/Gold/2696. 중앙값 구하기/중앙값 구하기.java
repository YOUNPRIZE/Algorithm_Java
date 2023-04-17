import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Integer> minPq = new PriorityQueue<>();
	static PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
 	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(N/2+1).append("\n");
			st = new StringTokenizer(br.readLine());
			
			int cnt = 0;
			
			for (int i = 1; i <= N; i++) {
				if (i >= 10 && i % 10 == 1) st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				
				if (minPq.size() == maxPq.size()) maxPq.add(num);
				else minPq.add(num);
				
				// maxPq는 중앙 이하 숫자만 저장
				if (!minPq.isEmpty()) {
					if (maxPq.peek() > minPq.peek()) {
						int a = maxPq.poll();
						int b = minPq.poll();
						maxPq.add(b);
						minPq.add(a);
					}
				}
				
				if (i % 2 == 1) {
					sb.append(maxPq.peek()).append(" ");
					if(++cnt % 10 == 0) sb.append("\n");
				}
			}
			sb.append("\n");
			maxPq.clear();
			minPq.clear();
		}
		System.out.println(sb.toString());
	}
}