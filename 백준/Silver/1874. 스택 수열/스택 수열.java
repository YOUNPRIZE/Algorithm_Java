import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		int number = 0;
		
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			if (m > number) {
				for (int j = number + 1; j <= m; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				number = m;
			} else if (stack.peek() != m)  {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			
			stack.pop();
			sb.append("-\n");
			
		}
		System.out.print(sb);
	}
}
