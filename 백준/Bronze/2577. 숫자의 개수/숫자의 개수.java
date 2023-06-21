import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int ans = A * B * C;
		
		String str = String.valueOf(ans);
		
		int[] num = new int[10];
		
		for (int i = 0; i < str.length(); i++) {
			char numb = str.charAt(i);
			switch (numb) {
			case '0':
				num[0]++;
				break;
			case '1':
				num[1]++;
				break;
			case '2':
				num[2]++;
				break;
			case '3':
				num[3]++;
				break;
			case '4':
				num[4]++;
				break;
			case '5':
				num[5]++;
				break;
			case '6':
				num[6]++;
				break;
			case '7':
				num[7]++;
				break;
			case '8':
				num[8]++;
				break;
			case '9':
				num[9]++;
				break;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(num[i]);
		}
	}
	
}