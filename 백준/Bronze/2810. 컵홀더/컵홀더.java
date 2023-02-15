import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String seat = br.readLine();
		seat = seat.replace("S", "*S*");
		seat = seat.replace("LL", "*LL*");
		seat = seat.replace("**", "*");
		
		int sum = 0;
		
		for (int i = 0; i < seat.length(); i++) {
			if(seat.charAt(i) == '*') sum++;
		}
		
		if (sum > N) System.out.println(N);
		else System.out.println(sum);
	}
}
