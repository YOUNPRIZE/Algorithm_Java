import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        String answer;
        while (str.length() != 1) {
        	int sum = 0;
	        for (int i = 0; i < str.length(); i++) {
	        	sum += Character.getNumericValue(str.charAt(i));
	        }
	        str = Integer.toString(sum);
	        cnt++;
        }
        System.out.println(cnt);
        answer = (Integer.parseInt(str) % 3 == 0) ? "YES" : "NO";
        System.out.print(answer);
    }
}