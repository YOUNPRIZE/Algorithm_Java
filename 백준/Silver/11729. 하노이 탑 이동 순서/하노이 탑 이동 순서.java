import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = (int) (Math.pow(2, N) -1);
		System.out.println(cnt);
		Hanoi(N, 1, 2, 3);
		System.out.print(sb);
	}
	
	static void Hanoi(int N, int start, int mid, int to) {
		if (N == 1) {
			//System.out.println(start + " " + to);
			sb.append(start).append(" ").append(to).append("\n");
			return;
		}
		
		Hanoi(N-1, start, to, mid);
		
		//System.out.println(start + " " + to);
		sb.append(start).append(" ").append(to).append("\n");
		
		Hanoi(N-1, mid, start, to);

	}
}
