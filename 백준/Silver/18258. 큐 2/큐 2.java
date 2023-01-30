import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int num = 0;
		
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
				case "push" :
					num = Integer.parseInt(st.nextToken());
					q.offer(num);
					break;
				case "pop" : 
					if (q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(q.poll()).append("\n");
					break;
				case "size" : 
					sb.append(q.size()).append("\n");
					break;
				case "empty" :
					if (q.isEmpty()) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "front" :
					if (q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(q.peek()).append("\n");
					break;
				case "back" :
					if (q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(num).append("\n");
					break;
			}
		}
		System.out.println(sb.toString());
	}
}
