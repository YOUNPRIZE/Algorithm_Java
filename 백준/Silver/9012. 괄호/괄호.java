import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			while (true) {
				if (str.contains("()")) str = str.replace("()", "");
				else break;
			}
			
			if (str.equals("")) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
