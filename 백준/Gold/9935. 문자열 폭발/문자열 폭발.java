import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		String bomb = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			sb.append(ch);
			if (sb.length() >= bomb.length()) {
				boolean checker = true;
				for (int j = 0; j < bomb.length(); j++) {
					char ch1 = sb.charAt(sb.length() - bomb.length() + j);
					char ch2 = bomb.charAt(j);
					if (ch1 != ch2) {
						checker = false;
						break;
					}
				}
				if (checker) {
					sb.delete(sb.length()-bomb.length(), sb.length());
				}
			}
		}
		
		if (sb.length() == 0) System.out.print("FRULA");
		else System.out.print(sb.toString());
	}
}
