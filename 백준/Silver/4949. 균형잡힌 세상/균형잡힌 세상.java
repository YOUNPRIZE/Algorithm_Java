import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String str = br.readLine();
			if (str.equals(".")) break;
			String ext = "";
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '[' || str.charAt(i) == ']') ext = ext + str.charAt(i);
			}
			while (true) {
				if (ext.contains("()")) ext = ext.replace("()", "");
				else if (ext.contains("[]")) ext = ext.replace("[]", "");
				else break;
			}
			
			if (ext.equals("")) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
