import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		//int N = Integer.parseInt(br.readLine());
		
		//int K = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		for (int i = 1; i <= N; i++ ) {
			queue.add(i);
		}
		
		int num = 0;
		
		while (queue.size() != 0) {
			num++;
			if (num % K == 0) {
				sb.append(queue.remove()).append(", ");
			} else queue.add(queue.poll());
		}
		
		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(sb.length() - 1);
		sb.append(">");
		System.out.println(sb.toString());
	}
}
